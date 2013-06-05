package ee.children.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Registration extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String parentCode = getPersonCode(request);
    render("registration.ftl", response, "person_code", parentCode,
        "kindergartens", kindergartens.all());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String childCode = request.getParameter("child_code");
    List<Integer> kindergartenIDs = parseIDs(request.getParameterValues("kindergarten"));

    parentChildren.register(getPersonCode(request), childCode);
    for (Integer kindergartenID : kindergartenIDs) {
      queue.enqueue(kindergartenID, childCode);
    }
    response.sendRedirect("/");
  }

  private List<Integer> parseIDs(String[] kindergartensIDs) {
    List<Integer> result = new ArrayList<Integer>();
    for (String stringId : kindergartensIDs) {
      Integer id = parseInt(stringId);
      if (id > 0) {
        result.add(id);
      }
    }
    return result;
  }
}