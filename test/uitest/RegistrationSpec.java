package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationSpec extends AbstractUITest {
  @Test
  public void parentCanRegisterChild() {
    loginAsParent("38106080010");
    registerChild("51306050010", "Tallinna Lindakivi Lasteaed", "Tallinna Arbu Lasteaed");

    $(".child").shouldHave(text("Child: 51306050010"));
    assertPosition(0, "Tallinna Lindakivi Lasteaed", 1);
    assertPosition(1, "Tallinna Arbu Lasteaed", 1);
  }

  @Test
  public void parentCanRegisterAnotherChild() {
    loginAsParent("parent_1");
    registerChild("child_1", "Tallinna Lindakivi Lasteaed", "Tallinna Arbu Lasteaed");
    registerChild("child_2", "Tallinna Arbu Lasteaed");

    $$(".child").shouldHave(texts("Child: child_1", "Child: child_2"));
    assertPosition(0, "Tallinna Lindakivi Lasteaed", 1);
    assertPosition(1, "Tallinna Arbu Lasteaed", 1);
    assertPosition(2, "Tallinna Arbu Lasteaed", 2);
  }

  private void assertPosition(int index, String kindergartenName, int position) {
    $(".kindergarten", index).shouldHave(text(kindergartenName));
    $(".position", index).shouldHave(text("Place: " + position));
  }

  private void registerChild(String childCode, String... kindergartens) {
    $(byText("Register child")).click();

    $(By.name("child_code")).val(childCode);

    int i = 0;
    for (String kindergarten : kindergartens) {
      $(By.name("kindergarten"), i++).selectOption(kindergarten);
    }

    $(byText("Register")).click();
  }
}
