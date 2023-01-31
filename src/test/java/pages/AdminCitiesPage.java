package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//*[@id=\"app\"]/div[6]/div/div/div[3]/button[2]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement successfullySavedMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tr")
    private List<WebElement> citiesTable;

    @FindBy(xpath = "//*[@id=\"edit\"][ text() = ‘NoviSad11’ ]")
    private WebElement editLatestCityButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]")
    private WebElement editSuccessfullySavedMessage;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[7]/div/div/div[2]/button[2]")
    private WebElement confirmDeletionButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement deletedMessage;

    public void createNewCity(String city) {
        newItemButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        newItemNameInput.clear();
        newItemNameInput.sendKeys(city);

        saveButton.click();
    }


}
