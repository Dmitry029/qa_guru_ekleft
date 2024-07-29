package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Tag("regression")
    @DisplayName("Проверка количества секций")
    void checkTheNumberOfSectionTest() {
        int sectionsNumber = 9;
        mainPage.openPage()
                .checkTheNumberOfSections(sectionsNumber);
    }

    @Test
    @Tag("regression")
    @DisplayName("Проверка подзаголовков секции 'Почему мы'")
    void checkWhyUsSectionSubTitles() {
        List<String> subTitles = List.of(
                "Для Закупок Заказчика",
                "Для ИТ и HR Заказчика",
                "Для Сотрудника");
        mainPage.openPage()
                .checkWhyUsSectionSubTitles(subTitles);
    }

    @Tag("regression")
    @ParameterizedTest(name = "Проверка правильности перехода на страницу {1} после нажатия кнопки '{1}'")
    @CsvSource({
            "#team, Наша команда",
            "#history, История компании"
    })
    void checkNavigationPages(String pageUrl, String buttonName) {
        mainPage.openPage()
                .navigateToPageByClickOn(buttonName);
        assertTrue(url().contains(pageUrl));
    }
}