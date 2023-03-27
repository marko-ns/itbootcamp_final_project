package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AdminCitiesTest extends BaseTest {

    String city = "Random";

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToLoginPage();
        //presence of login button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")));
        loginPage.login("admin@admin.com", "12345");
        //presence of "Welcome" header message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/h1")));
        welcomePage.getToAdminCities();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void afterMethod() {
        //presence of logout button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")));
        adminCitiesPage.getLogoutButton().click();
    }

    @Test
    public void urlAndLogoutButtonCheck() {
        Assert.assertTrue(webDriver.getCurrentUrl().endsWith("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }

    @Test(priority = 1)
    public void createNewCity() {

        adminCitiesPage.createNewCity(city);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        Assert.assertTrue(adminCitiesPage.getSuccessfullySavedMessage().getText().contains("Saved successfully"));
    }

    @Test(priority = 3)
    public void editCity() {
        //presence of table
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table")));

        for (WebElement city : adminCitiesPage.getCitiesTable()) {
            if (city.getText().contains(this.city)) {
                WebElement editButton = city.findElement(By.id("edit"));    //finding a Web element (edit button) within a Web element (row that contains my city)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                editButton.click();
                adminCitiesPage.getEditInput().sendKeys(" -edited");
                adminCitiesPage.getSaveButton().click();
            }
        }
        //presence of "Saved successfully" message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]")));

        Assert.assertTrue(adminCitiesPage.getEditSuccessfullySavedMessage().getText().contains("Saved successfully"));
    }

    @Test(priority = 2)
    public void searchCity() {
        //presence of search bar
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        adminCitiesPage.getSearchInput().sendKeys(this.city);
        //presence of searched city
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")));
        WebElement result = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(result.getText().contains(this.city));
    }

    @Test(priority = 4)
    public void deleteCity() {
        //presence of search bar
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        adminCitiesPage.getSearchInput().sendKeys(this.city);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")));
        WebElement result = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(result.getText().contains(this.city));

        adminCitiesPage.getDeleteButton().click();

        WebElement dltButton = webDriver.findElement(By.className("text--lighten3"));
        dltButton.click();
        //presence of "Deleted successfully" message
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(adminCitiesPage.getDeletedMessage().getText().contains("Deleted successfully"));
    }
}
