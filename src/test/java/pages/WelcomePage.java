package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verificationMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminButton;

    @FindBy(className = "v-list-item__title")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;

    public WebElement getMyProfileButton() {
        return myProfileButton;
    }

    public WebElement getVerificationMessage() {
        return verificationMessage;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void getToAdminCities() {
        adminButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div")));
        citiesButton.click();
//        Select select = new Select(adminButton);
//        select.selectByIndex(1);
    }
}
