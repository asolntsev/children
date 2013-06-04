package ee.children.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends BaseServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String parentCode = getPersonCode(request);
    render("registration.ftl", response, "person_code", parentCode,
        "childrensGardens", childrensGardens.getChildrenGardens());
  }
}