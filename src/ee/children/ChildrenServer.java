package ee.children;

import ee.children.web.Dashboard;
import ee.children.web.Login;
import ee.children.web.Logout;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public class ChildrenServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler context = new ServletContextHandler(SESSIONS);
    context.setResourceBase("web");
    context.addServlet(Login.class, "/login");
    context.addServlet(Logout.class, "/logout");
    context.addServlet(Dashboard.class, "/dashboard");
    context.addServlet(org.eclipse.jetty.servlet.DefaultServlet.class, "/*");
    server.setHandler(context);

    server.start();
    server.join();
  }
}
