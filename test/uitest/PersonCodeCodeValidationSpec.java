package uitest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class PersonCodeCodeValidationSpec extends AbstractUITest {
  @Before
  public void logout() {
    open("/logout");
  }

  @Test
  public void inputEmpty() {
    loginAsParent("1111");
    open("/logout");
    $(By.name("person_code")).shouldBe(empty);
  }

  @Test
  public void personCodeIsMandatory() {
    loginWithString("");
    $(".message").shouldHave(text("Person code is required"));
  }

  @Test
  public void personCodeCantContainSpases() {
    loginWithString(" ");
    $(".message").shouldHave(text("Person code is required"));
  }

  private void loginWithString(String stringCode) {
    $(By.name("person_code")).val(stringCode);
    $(byText("Sign in")).click();
  }

  @Test
  public void personCodeCanContainOnlyNumber() {
    loginWithString("ABC 234");
    $(".message").shouldHave(text("Person code shall contains 11 numbers"));
  }

  @Test
  public void personCodeIsValidLoginSuccess(){
    loginWithString("38012143721");
    assertEquals(title(), "kindergartens");
    $(".parent").shouldHave(text("38012143721"));
  }
}
