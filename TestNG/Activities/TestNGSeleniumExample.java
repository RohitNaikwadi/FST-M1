package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGSeleniumExample {


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
    }

    @Test(priority = 1)
    public void homepageTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Training Support");
    }

    @Test(priority = 2)
    public void aboutPageTest()
    {
        driver.findElement(By.id("about-link")).click();
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
