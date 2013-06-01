package ee.children.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Registration extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String parentCode = getPersonCode(request);
    render("registration.ftl", response, "person_code", parentCode,
        "childrensGardens", childrensGardens.getChildrenGardens());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String childCode = request.getParameter("child_code");
    parentChildren.register(getPersonCode(request), childCode);

    for (String garden : request.getParameterValues("garden")) {
      if (!"0".equals(garden)) {
        queueRepository.add(childCode, childrensGardens.get(parseInt(garden)));
      }
    }

    response.sendRedirect("/");
  }
}