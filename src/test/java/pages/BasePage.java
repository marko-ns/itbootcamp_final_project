package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.webDriver = driver;
        this.webDriverWait = driverWait;
        PageFactory.initElements(this.webDriver, this);
    }
}
