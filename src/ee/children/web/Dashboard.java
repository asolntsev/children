package ee.children.web;

import ee.children.model.ChildrensGarden;
import ee.children.model.ParentChildRepository;
import ee.children.model.QueueRepository;
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
  ParentChildRepository parentChildren = new ParentChildRepository();
  QueueRepository queueRepository = new QueueRepository();

  @Override
  public void init() throws ServletException {
    ChildrensGarden g1 = new ChildrensGarden(1, "Tallinna Lindakivi Lasteaed");
    ChildrensGarden g2 = new ChildrensGarden(2, "Tallinna Arbu Lasteaed");
    ChildrensGarden g3 = new ChildrensGarden(3, "Tallinna Lasteaed Kirsike");

    parentChildren.register("3", "1111111111");
    parentChildren.register("4", "1111111111");
    parentChildren.register("3", "2222222222");
    parentChildren.register("3", "3333333333");

    queueRepository.add("1111111111", g1);
    queueRepository.add("1111111111", g2);
    queueRepository.add("1111111111", g3);
    queueRepository.add("2222222222", g2);
    queueRepository.add("2222222222", g3);
    queueRepository.add("3333333333", g3);
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