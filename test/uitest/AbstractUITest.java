package uitest;

import com.codeborne.selenide.Configuration;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ee.children.ChildrenServer;
import ee.children.ChildrenServer.ChildrenModule;
import ee.children.model.ParentChildRepository;
import ee.children.model.QueueRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Integer.parseInt;

public class AbstractUITest {
  private static Injector injector;
  private static ChildrenServer server;

  @BeforeClass
  public static void runServer() throws Exception {
    if (server == null) {
      injector = Guice.createInjector(new ChildrenModule());
      server = injector.getInstance(ChildrenServer.class);
      String port = System.getProperty("http.port", "8081");
      server.start(parseInt(port));
      Configuration.baseUrl = "http://localhost:" + port;
    }
  }

  @Before
  public void resetQueues() {
    injector.getInstance(ParentChildRepository.class).deleteAll();
    injector.getInstance(QueueRepository.class).deleteAll();
  }

  protected void loginAsParent(String parentCode) {
    open("/logout");
    $(By.name("person_code"))
        .setValue(parentCode)
        .pressEnter();
  }
}
