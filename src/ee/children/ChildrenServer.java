package ee.children;

import ee.children.web.Dashboard;
import ee.children.web.Login;
import ee.children.web.Logout;
import ee.children.web.Registration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public class ChildrenServer {
  private Server jetty;

  public void start(int port) throws Exception {
    jetty = new Server(port);
    ServletContextHandler context = new ServletContextHandler(SESSIONS);
    context.setResourceBase("web");
    context.addServlet(Login.class, "/login");
    context.addServlet(Logout.class, "/logout");
    context.addServlet(Registration.class, "/registration");
    context.addServlet(Dashboard.class, "/");
    context.addServlet(org.eclipse.jetty.servlet.DefaultServlet.class, "/img/*");
    context.addServlet(org.eclipse.jetty.servlet.DefaultServlet.class, "/css/*");
    context.addServlet(org.eclipse.jetty.servlet.DefaultServlet.class, "/js/*");
    jetty.setHandler(context);

    addShutdownHook();
    jetty.start();
  }

  public void stop() {
    if (jetty != null) {
      try {
        jetty.stop();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void addShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        ChildrenServer.this.stop();
      }
    });
  }

  public static void main(String[] args) throws Exception {
    new ChildrenServer().start(8080);
  }
}
