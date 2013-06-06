package ee.children.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLoggedIn(request)) {
            response.sendRedirect("/dashboard");
            return;
        }

        render("login.html", response, "message", "", "person_code", "");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personCode = request.getParameter("person_code").trim();

        if (personCode.length() == 0) {
          render("login.html", response, "person_code", personCode,
              "message", "Person code is required");
          return;
        }
      if (!personCode.matches("\\d{11}"))
      {
        render("login.html", response, "person_code", personCode,
            "message", "Person code shall contains 11 numbers");
        return;
      }

        HttpSession session = request.getSession(true);
        session.setAttribute("person_code", personCode);
        response.sendRedirect("/dashboard");
    }
}