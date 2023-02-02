package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProfileTest extends BaseTest {

    String city = "Cali";

//    public String randomCity(){
//        List<String> citiesList = Arrays.asList("New York", "Cali", "Havana");
//        Random random = new Random();
//        String city = citiesList.get(random.nextInt(citiesList.size()));
//        return city;
//    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getToLoginPage();
        //presence of Email input field
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        loginPage.login("admin@admin.com", "12345");
        //presence of My Profile button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")));
        welcomePage.getMyProfileButton().click();
        //presence of Save button
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")));
    }

    @Test
    public void editProfile() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String country = faker.country().name();
        String twitterLink = "http://" + faker.internet().url();
        String gitHubLink = "http://" + faker.internet().url();

        myProfilePage.getNameInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getNameInput().sendKeys(Keys.DELETE);
        myProfilePage.getNameInput().sendKeys(name);

        myProfilePage.getPhoneInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getPhoneInput().sendKeys(Keys.DELETE);
        myProfilePage.getPhoneInput().sendKeys(phone);

        myProfilePage.getCityInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getCityInput().sendKeys(Keys.DELETE);
        myProfilePage.getCityInput().sendKeys(city);
        myProfilePage.getCityInput().sendKeys(Keys.RETURN);

        myProfilePage.getCountryInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getCountryInput().sendKeys(Keys.DELETE);
        myProfilePage.getCountryInput().sendKeys(country);

        myProfilePage.getTwitterInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getTwitterInput().sendKeys(Keys.DELETE);
        myProfilePage.getTwitterInput().sendKeys(twitterLink);

        myProfilePage.getGitHubInput().sendKeys(Keys.CONTROL + "a");
        myProfilePage.getGitHubInput().sendKeys(Keys.DELETE);
        myProfilePage.getGitHubInput().sendKeys(gitHubLink);

        myProfilePage.getSaveButton().click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));

        Assert.assertTrue(myProfilePage.getMessage().getText().contains("Profile saved successfuly"));

        Assert.assertEquals(myProfilePage.getNameInput().getAttribute("value"), name);
        Assert.assertEquals(myProfilePage.getPhoneInput().getAttribute("value"), phone);
        Assert.assertEquals(myProfilePage.getCityInput().getAttribute("value"), city);
        Assert.assertEquals(myProfilePage.getCountryInput().getAttribute("value"), country);
        Assert.assertEquals(myProfilePage.getTwitterInput().getAttribute("value"), twitterLink);
        Assert.assertEquals(myProfilePage.getGitHubInput().getAttribute("value"), gitHubLink);
    }
}
