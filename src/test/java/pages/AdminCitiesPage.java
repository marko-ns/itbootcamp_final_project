package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement newItemButton;

    @FindBy(id = "name")
    private WebElement newItemNameInput;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement successfullySavedMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private List<WebElement> citiesTable;

    @FindBy(xpath = "//*[@id=\"edit\"][ text() = ‘NoviSad11’ ]") //not good
    private WebElement editLatestCityButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement editSuccessfullySavedMessage;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[7]/div/div/div[2]/button[2]")
    private WebElement confirmDeletionButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement deletedMessage;

    @FindBy(id = "name")
    private WebElement editInput;

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getEditInput() {
        return editInput;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSuccessfullySavedMessage() {
        return successfullySavedMessage;
    }

    public List<WebElement> getCitiesTable() {
        return citiesTable;
    }

    public WebElement getEditSuccessfullySavedMessage() {
        return editSuccessfullySavedMessage;
    }

    public void createNewCity(String city) {

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")));
        newItemButton.click();

        newItemNameInput.clear();
        newItemNameInput.sendKeys(city);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        saveButton.click();
    }


}
