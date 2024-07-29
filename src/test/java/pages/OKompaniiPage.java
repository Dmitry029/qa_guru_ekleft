package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OKompaniiPage {

    @Step("Открыть страницу 'О компании'")
    public OKompaniiPage openPage() {
        open("o-kompanii/");
        return this;
    }

    @Step("Проверить заголовок страницы {0}")
    public void checkPageTitle(String pageTitle) {
        $(".about-page-info__content").should(text(pageTitle));
    }
}
