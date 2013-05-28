package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSpec extends AbstractUITest {
    @Test
    public void userCanLoginByPersonCode() {
        open("/login");
        $(By.name("person_code"))
                .setValue("38106080010")
                .pressEnter();
        $(".parent").shouldHave(text("Parent: 38106080010"));
    }
}
