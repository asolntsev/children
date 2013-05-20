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

        render("login.html", response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String personCode = request.getParameter("person_code");
        final HttpSession session = request.getSession(true);
        session.setAttribute("person_code", personCode);
        response.sendRedirect("/dashboard");
    }
}