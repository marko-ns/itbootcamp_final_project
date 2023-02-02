package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

    @Test
    public void forbidsHome(){
        webDriver.get("https://vue-demo.daniel-avellaneda.com/home");
        //presence of Login header
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[1]/h1")));

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void forbidsProfile(){
        webDriver.get("https://vue-demo.daniel-avellaneda.com/profile");
        //presence of Login header
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[1]/h1")));

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://vue-demo.daniel-avellaneda.com/login");
    }
}
