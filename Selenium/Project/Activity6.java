package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    @Test
    public static void verifySearchDirectoryHeading() throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find About Us link using id and click it
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_directory_viewDirectory"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_directory_viewDirectory"))));
        Thread.sleep(2000);
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='head']//h1[text()='Search Directory']"))));

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='head']//h1")).getText(), "Search Directory");
        // Close the browser
        driver.quit();
    }
}