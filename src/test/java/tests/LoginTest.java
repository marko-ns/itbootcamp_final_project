package tests;

import com.github.javafaker.Faker;
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

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));


        String emailInputFieldType = loginPage.getEmailInput().getAttribute("type");
        String passwordInputFieldType = loginPage.getPasswordInput().getAttribute("type");

        Assert.assertEquals(emailInputFieldType, "email");
        Assert.assertEquals(passwordInputFieldType, "password");
    }

    @Test
    public void invalidUser() {
        Faker faker = new Faker();

        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));

        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        loginPage.login(fakeEmail, fakePassword);

        //presence of error message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("User does not exist"));
    }

    @Test
    public void validEmailInvalidPassword() {
        Faker faker = new Faker();

        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));

        String email = "admin@admin.com";
        String invalidPassword = faker.internet().password();

        loginPage.login(email, invalidPassword);

        //presence of error message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(loginPage.getErrorMessage().getText().contains("Wrong password"));
    }

    @Test
    public void validLogin() {

        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));

        String email = "admin@admin.com";
        String password = "12345";

        loginPage.login(email, password);

        //presence of "Welcome Super Administrator" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void logout(){

        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));

        String email = "admin@admin.com";
        String password = "12345";

        loginPage.login(email, password);

        //presence of "Welcome Super Administrator" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));

        Assert.assertTrue(welcomePage.getLogoutButton().isDisplayed());

        welcomePage.getLogoutButton().click();

        //presence of "Login" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[1]/h1")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"));

        webDriver.get("https://vue-demo.daniel-avellaneda.com/home");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"));
    }
}
