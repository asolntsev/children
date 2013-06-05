package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LogoutSpec extends AbstractUITest {
  @Test
  public void userCanLogout() {
    loginAsParent("38106080010");

    $(By.linkText("Log out")).click();
    $(".parent").shouldNot(exist);
    $(byText("Please sign in")).shouldBe(visible);
  }
}
