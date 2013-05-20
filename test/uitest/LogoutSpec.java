package uitest;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogoutSpec {
    @Test
    public void userCanLogout() {
        open("/logout");
        open("/login");
        $(By.name("person_code"))
                .setValue("38106080010")
                .pressEnter();

        $(By.linkText("Log out")).click();
        $(".parent").shouldNot(exist);
        $(byText("Please sign in")).shouldBe(visible);
    }
}
