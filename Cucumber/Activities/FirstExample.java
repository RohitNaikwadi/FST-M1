package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstExample extends BaseClass{

    @BeforeAll
    public static void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
    }

    @Given("the user on homepage")
    public void openTSHomePage()
    {
        driver.get("https://v1.training-support.net");
        Assert.assertEquals("Training Support",driver.getTitle());

    }

    @When("the user click on About us link")
    public void clickAboutUs()
    {
driver.findElement(By.id("about-link")).click();
    }

    @Then("the user will redirected to the about homepage")
    public void redrirectToAboutUSpage()
    {
Assert.assertEquals("About Training Support",driver.getTitle());
    }

    @Then("close the browser")
    public void closeBrowser()
    {
driver.quit();
    }



}
