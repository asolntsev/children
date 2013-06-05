package uitest;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginSpec extends AbstractUITest {
  @Test
  public void userCanLoginByPersonCode() {
    loginAsParent("38106080010");
    $(".parent").shouldHave(text("Parent: 38106080010"));
  }
}
