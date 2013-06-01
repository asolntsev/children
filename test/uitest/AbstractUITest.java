package uitest;

import ee.children.ChildrenServer;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AbstractUITest {
  private static ChildrenServer server;

  @BeforeClass
  public static void runServer() throws Exception {
    if (server == null) {
      server = new ChildrenServer();
      server.start(8080);
    }
  }

  protected void loginAsParent() {
    open("/logout");
    $(By.name("person_code"))
        .setValue("38106080010")
        .pressEnter();
  }
}
