package ee.children.web;

import ee.children.model.ChildPosition;
import ee.children.model.ChildPositions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dashboard extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!isLoggedIn(request)) {
      response.sendRedirect("/login");
      return;
    }

    String parentCode = getPersonCode(request);
    render("dashboard.ftl", response, "person_code", parentCode,
        "childrenPositions", childrenPositions(parentCode));
  }

  private List<ChildPositions> childrenPositions(String parentCode) {
    Set<String> children = parentChildren.children(parentCode);
    List<ChildPositions> result = new ArrayList<ChildPositions>();

    for (String childCode : children) {
      List<ChildPosition> childPositions = queueRepository.getChildPositions(childCode);
      result.add(new ChildPositions(childCode, childPositions));
    }
    return result;
  }
}