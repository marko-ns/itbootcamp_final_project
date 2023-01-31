package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.WelcomePage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;

    protected WelcomePage welcomePage;

    @BeforeClass
    public void beforeClass(){
        this.webDriver = new ChromeDriver();
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.homePage = new HomePage(webDriver, webDriverWait);
        this.loginPage = new LoginPage(webDriver, webDriverWait);
        this.welcomePage = new WelcomePage(webDriver, webDriverWait);
    }

    @AfterClass
    public void afterClass(){
        webDriver.quit();
    }

    @BeforeMethod
    public void beforeMethod(){
        webDriver.get("https://vue-demo.daniel-avellaneda.com/");
        webDriver.manage().window().maximize();
    }
}
