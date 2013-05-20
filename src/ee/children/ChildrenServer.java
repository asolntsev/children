package ee.children;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ChildrenServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setResourceBase("web");
        context.addServlet(ee.children.Login.class, "/login");
        context.addServlet(ee.children.Logout.class, "/logout");
        context.addServlet(ee.children.Dashboard.class, "/dashboard");
        context.addServlet(org.eclipse.jetty.servlet.DefaultServlet.class, "/*");

        server.setHandler(context);
        server.start();
        server.join();
    }
}
