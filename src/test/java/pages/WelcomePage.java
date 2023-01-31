package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage{

    public WelcomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}
