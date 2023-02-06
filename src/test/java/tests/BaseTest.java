package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver webDriver;

    protected WebDriverWait webDriverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected WelcomePage welcomePage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected MyProfilePage myProfilePage;

    @BeforeClass
    public void beforeClass() {
        this.webDriver = new ChromeDriver();
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.homePage = new HomePage(webDriver, webDriverWait);
        this.loginPage = new LoginPage(webDriver, webDriverWait);
        this.welcomePage = new WelcomePage(webDriver, webDriverWait);
        this.signupPage = new SignupPage(webDriver, webDriverWait);
        this.adminCitiesPage = new AdminCitiesPage(webDriver, webDriverWait);
        this.myProfilePage = new MyProfilePage(webDriver, webDriverWait);
    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.get("https://vue-demo.daniel-avellaneda.com/");
        webDriver.manage().window().maximize();
    }
}
