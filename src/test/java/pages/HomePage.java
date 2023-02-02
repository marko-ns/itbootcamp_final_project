package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(className = "btnLocaleActivation")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerText;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginPageButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement signupButton;

    @FindBy(id = "list-item-75")
    private WebElement esButton;

    @FindBy(id = "list-item-73")
    private WebElement enButton;

    @FindBy(id = "list-item-77")
    private WebElement frButton;

    public WebElement getFrButton() {
        return frButton;
    }

    public WebElement getEnButton() {
        return enButton;
    }

    public WebElement getEsButton() {
        return esButton;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public void getToLoginPage(){
        loginPageButton.click();
    }

    public void getToSignupPage(){
        signupButton.click();
    }


}
