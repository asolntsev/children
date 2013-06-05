package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationSpec extends AbstractUITest {
  @Test
  public void parentCanRegisterChild() {
    loginAsParent();
    $(byText("Register child")).click();
    $(By.name("child_code")).val("51306050010");
    $(By.name("kindergarten"), 0).selectOption("Tallinna Arbu Lasteaed");
    $(By.name("kindergarten"), 1).selectOption("Tallinna Lindakivi Lasteaed");
    $(byText("Register")).click();

    $(".child").shouldHave(text("51306050010"));
    $$(".kindergarten").shouldHave(size(2));
    $$(".kindergarten").shouldHave(texts("Tallinna Lindakivi Lasteaed", "Tallinna Arbu Lasteaed"));
    $$(".position").shouldHave(texts("Place: 1", "Place: 1"));
  }
}
