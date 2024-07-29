package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OKompaniiPage;

public class OKompaniiPageTest extends BaseTest{

    private final OKompaniiPage oKompaniiPage = new OKompaniiPage();

    @Test
    @Tag("smoke")
    @Tag("regression")
    @DisplayName("Проверка заголовка страницы")
    void checkPageTitle() {
        String pageTitle = "О компании";
        oKompaniiPage.openPage().checkPageTitle(pageTitle);
    }
}
