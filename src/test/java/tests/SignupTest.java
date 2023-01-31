package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToSignupPage();
    }

    @Test
    public void correctSignupPageUrl(){

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[1]/h1")));

        Assert.assertTrue(webDriver.getCurrentUrl().endsWith("/signup"));
    }
}
