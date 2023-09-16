

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {

    @Test
    public static void fetchEmergencyContacts() throws InterruptedException {
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

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_pim_viewMyDetails"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_pim_viewMyDetails"))));
        Thread.sleep(2000);

        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Emergency Contacts"))));

        driver.findElement(By.linkText("Emergency Contacts")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//thead"))));

        List<WebElement> tableHead = driver.findElements(By.xpath("//thead//tr//th"));

        for (WebElement ele : tableHead) {
            System.out.print(ele.getText());
            System.out.print(" ");
        }
        System.out.println();

        List<WebElement> tableBodyRows = driver.findElements(By.xpath("//tbody//tr"));

        List<WebElement> tableBodyRowOneCol = tableBodyRows.get(0).findElements(By.xpath("//tbody//tr[1]//td"));
        for (WebElement ele : tableBodyRowOneCol) {
            System.out.print(ele.getText());
            System.out.print(" ");
        }
        System.out.println();
        List<WebElement> tableBodyRowTwoCol = tableBodyRows.get(1).findElements(By.xpath("//tbody//tr[2]//td"));
        for (WebElement ele : tableBodyRowTwoCol) {
            System.out.print(ele.getText());
            System.out.print(" ");
        }
        driver.quit();
    }
}
