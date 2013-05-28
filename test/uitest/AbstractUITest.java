package uitest;

import ee.children.ChildrenServer;
import org.junit.BeforeClass;

public class AbstractUITest {
  private static ChildrenServer server;

  @BeforeClass
  public static void runServer() throws Exception {
    if (server == null) {
      server = new ChildrenServer();
      server.start(8080);
    }
  }
}
