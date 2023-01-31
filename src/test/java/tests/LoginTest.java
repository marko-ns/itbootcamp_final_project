package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToLoginPage();
    }

    @Test
    public void loginInUrl(){
        String currentUrl = webDriver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("/login"));
    }
}
