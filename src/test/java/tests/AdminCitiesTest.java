package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToLoginPage();
        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        loginPage.login("admin@admin.com", "12345");
        //presence of "Welcome" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));
        welcomePage.getToAdminCities();
    }

    @Test
    public void urlAndLogoutButtonCheck() {
        Assert.assertTrue(webDriver.getCurrentUrl().endsWith("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }
}
