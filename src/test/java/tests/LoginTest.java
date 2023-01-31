package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToLoginPage();
    }

    @Test
    public void correctLoginPageUrl() {
        String currentUrl = webDriver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("/login"));
    }

    @Test
    public void correctInputTypes() {
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));


        String emailInputFieldType = loginPage.getEmailInput().getAttribute("type");
        String passwordInputFieldType = loginPage.getPasswordInput().getAttribute("type");

        Assert.assertEquals(emailInputFieldType, "email");
        Assert.assertEquals(passwordInputFieldType, "password");
    }
}
