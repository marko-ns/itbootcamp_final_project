package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verificationMessage;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
    }

    public void signUp(String name, String email, String password, String confirmationPassowrd) {
        nameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        confirmPasswordInput.clear();

        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmationPassowrd);

        signUpButton.click();
    }
}
