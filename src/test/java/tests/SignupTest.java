package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToSignupPage();
    }

    @Test
    public void correctSignupPageUrl() {

        //presence of "Signup" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[1]/h1")));

        Assert.assertTrue(webDriver.getCurrentUrl().endsWith("/signup"));
    }

    @Test
    public void correctInputTypes() {

        //presence of "Signup" button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));

        String email = signupPage.getEmailInput().getAttribute("type");
        String password = signupPage.getPasswordInput().getAttribute("type");
        String confirmPassword = signupPage.getConfirmPasswordInput().getAttribute("type");

        Assert.assertEquals(email, "email");
        Assert.assertEquals(password, "password");
        Assert.assertEquals(confirmPassword, "password");
    }

    @Test
    public void userAlreadyExists(){

        //presence of "Signup" button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));

        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confPassword = "123654";

        signupPage.signUp(name, email, password, confPassword);

        //presence of "Already exists" message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")));

        Assert.assertTrue(webDriver.getCurrentUrl().endsWith("/signup"));
        Assert.assertTrue(signupPage.getErrorMessage().getText().contains("E-mail already exists"));
    }

    @Test
    public void validSignup(){

        //presence of "Signup" button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")));

        String name = "markmark1111";
        String email = "markmark1111@gmail.com";
        String password = "13579";
        String confPassword = "13579";

        signupPage.signUp(name, email, password, confPassword);

        webDriverWait.until(ExpectedConditions.urlContains("/home"));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));

        Assert.assertTrue(welcomePage.getVerificationMessage().getText().contains("Verify your account"));
    }
}
