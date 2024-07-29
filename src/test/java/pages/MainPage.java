package pages;

import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        $("[alt='Ekleft logo']").shouldBe(visible);
        return this;
    }

    @Step("Проверить количество секций {0}")
    public void checkTheNumberOfSections(int sectionsNumber) {
        $$("section[class]").shouldHave(size(sectionsNumber));
    }

    @Step("Проверить названия подзаголовков")
    public void checkWhyUsSectionSubTitles(List<String> subTitles) {
        $$("[class='why-us'] li[id] h4").shouldHave(texts(subTitles));
    }

    @Step("Перейти на страницу {0}")
    public void navigateToPageByClickOn(String pageName) {
        $x(String.format("//*[@class='about-buttons']//*[text()='%s']", pageName))
                .click();
    }
}
