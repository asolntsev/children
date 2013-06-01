package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChildRegistrationSpec extends AbstractUITest {
  @Test
  public void parentCanRegisterChildToUpTo3ChildrensGardens() {
    loginAsParent();
    $(".no-children").shouldBe(visible).shouldHave(text("no children"));
    $(byText("Register child")).click();
    $(By.name("child_code")).setValue("51306010000");
    $(By.name("garden"), 0).selectOption("Tallinna Arbu Lasteaed");
    $(By.name("garden"), 1).selectOption("Tallinna Lasteaed Kirsike");
    $(byText("Register")).click();

    $(".no-children").shouldNotBe(visible);

    $$(".child_code").shouldHave(texts("51306010000"));
    $$(".garden").shouldHave(texts("Tallinna Arbu Lasteaed", "Tallinna Lasteaed Kirsike"));
    $$(".place").shouldHave(texts("Place: 1 / 1", "Place: 1 / 1"));
  }
}
