package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProfileTest extends BaseTest {

    String[] cities = {"Barranquilla", "Bogotá", "Bucaramanga", "Cali", "Chicago", "Medellín", "New York", "Oakland", "San Francisco", "San Leandro"};
    String city = cities[(int) (Math.random() * cities.length)];

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

        myProfilePage.fillOutInputFields(name, phone, city, country, twitterLink, gitHubLink);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")));

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
