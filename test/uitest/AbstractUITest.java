package uitest;

import com.codeborne.selenide.Configuration;
import ee.children.ChildrenServer;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Integer.parseInt;

public class AbstractUITest {
  private static ChildrenServer server;

  @BeforeClass
  public static void runServer() throws Exception {
    if (server == null) {
      server = new ChildrenServer();
      String port = System.getProperty("http.port", "8081");
      server.start(parseInt(port));
      Configuration.baseUrl = "http://localhost:" + port;
    }
  }

  protected void loginAsParent() {
    open("/logout");
    $(By.name("person_code"))
        .setValue("38106080010")
        .pressEnter();
  }
}
