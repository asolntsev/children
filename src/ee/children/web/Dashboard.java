package ee.children.web;

import ee.children.model.ChildState;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!isLoggedIn(request)) {
      response.sendRedirect("/login");
      return;
    }

    String parentCode = getPersonCode(request);
    List<ChildState> childrenStates = getChildrenStates(parentCode);

    render("dashboard.ftl", response, "person_code", parentCode, "childrenStates", childrenStates);
  }

  private List<ChildState> getChildrenStates(String parentCode) {
    List<String> children = parentChildren.getChildren(parentCode);

    List<ChildState> childrenStates = new ArrayList<ChildState>();
    for (String child : children) {
      childrenStates.add(queue.getChildState(child));
    }
    return childrenStates;
  }
}