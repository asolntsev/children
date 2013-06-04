package ee.children.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dashboard extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!isLoggedIn(request)) {
      response.sendRedirect("/login");
      return;
    }

    String parentCode = getPersonCode(request);
    render("dashboard.ftl", response, "person_code", parentCode);
  }
}