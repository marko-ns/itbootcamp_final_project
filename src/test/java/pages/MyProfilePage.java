package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "urlTwitter")
    private WebElement twitterInput;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message;

    @FindBy(id = "city")
    private WebElement cityInput;

    public void fillOutInputFields(String name, String phone, String city, String country, String twitterLink, String gitHubLink) {
        nameInput.sendKeys(Keys.CONTROL + "a");
        nameInput.sendKeys(name);

        phoneInput.sendKeys(Keys.CONTROL + "a");
        phoneInput.sendKeys(phone);

        cityInput.sendKeys(Keys.CONTROL + "a");
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.TAB);

        countryInput.sendKeys(Keys.CONTROL + "a");
        countryInput.sendKeys(country);

        twitterInput.sendKeys(Keys.CONTROL + "a");
        twitterInput.sendKeys(twitterLink);

        gitHubInput.sendKeys(Keys.CONTROL + "a");
        gitHubInput.sendKeys(gitHubLink);
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public WebElement getCountryInput() {
        return countryInput;
    }

    public WebElement getTwitterInput() {
        return twitterInput;
    }

    public WebElement getGitHubInput() {
        return gitHubInput;
    }
}
