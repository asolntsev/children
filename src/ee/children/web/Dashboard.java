package ee.children.web;

import ee.children.model.QueueRepository.ChildPosition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dashboard extends BaseServlet {
  @Override
  public void init() throws ServletException {
/*
    parentChildren.register("parent:3", "1111111111");
    parentChildren.register("parent:4", "1111111111");
    parentChildren.register("parent:3", "2222222222");
    parentChildren.register("parent:3", "3333333333");

    queueRepository.add("1111111111", childrensGardens.get(1));
    queueRepository.add("1111111111", childrensGardens.get(2));
    queueRepository.add("1111111111", childrensGardens.get(3));
    queueRepository.add("2222222222", childrensGardens.get(2));
    queueRepository.add("2222222222", childrensGardens.get(3));
    queueRepository.add("3333333333", childrensGardens.get(3));
*/
  }

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

  private Map<String, List<ChildPosition>> childrenPositions(String parentCode) {
    Set<String> children = parentChildren.children(parentCode);
    final Map<String, List<ChildPosition>> result = new LinkedHashMap<String, List<ChildPosition>>();

    for (String childCode : children) {
      List<ChildPosition> childPositions = queueRepository.getChildPositions(childCode);
      result.put(childCode, childPositions);
    }
    return result;
  }
}