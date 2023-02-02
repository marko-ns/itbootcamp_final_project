package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    @Test
    public void localeES() {
        homePage.getLanguageButton().click();

        //presence of list of languages
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div")));
        homePage.getEsButton().click();

        Assert.assertEquals(homePage.getHeaderText().getText(), "Página de aterrizaje");
    }

    @Test
    public void localeEN() {
        homePage.getLanguageButton().click();

        //presence of list of languages
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div")));
        homePage.getEnButton().click();

        Assert.assertEquals(homePage.getHeaderText().getText(), "Landing");
    }

    @Test
    public void localeFR() {
        homePage.getLanguageButton().click();

        //presence of list of languages
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div")));
        homePage.getFrButton().click();

        Assert.assertEquals(homePage.getHeaderText().getText(), "Page d'atterrissage");
    }
}
