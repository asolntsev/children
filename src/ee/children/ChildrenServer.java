package ee.children;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ee.children.web.Dashboard;
import ee.children.web.Login;
import ee.children.web.Logout;
import ee.children.web.Registration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.http.HttpServlet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public class ChildrenServer {
  static Map<String, Class<? extends HttpServlet>> mappings = new LinkedHashMap<String, Class<? extends HttpServlet>>() {{
    put("/login", Login.class);
    put("/logout", Logout.class);
    put("/registration", Registration.class);
    put("/", Dashboard.class);
    put("/img/*", DefaultServlet.class);
    put("/css/*", DefaultServlet.class);
    put("/js/*", DefaultServlet.class);
  }};

  private Injector injector = Guice.createInjector(new ChildrenModule());
  private Server jetty;

  public void start(int port) throws Exception {
    jetty = new Server(port);
    ServletContextHandler context = new ServletContextHandler(SESSIONS);
    context.setResourceBase("web");
    for (Entry<String, Class<? extends HttpServlet>> mapping : mappings.entrySet()) {
      context.addServlet(mapping.getValue(), mapping.getKey());
    }
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

  private class ChildrenModule extends AbstractModule {
    @Override
    protected void configure() {
      for (Class<? extends HttpServlet> servletClass : mappings.values()) {
        requestStaticInjection(servletClass);
      }
    }
  }
}
