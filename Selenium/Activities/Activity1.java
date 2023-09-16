package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");

        String pageTitle = driver.getTitle();
        String pageHeading = driver.findElement(By.className("header")).getText();
        System.out.println("Page Title" + pageTitle);
        System.out.println("Page heading" + pageHeading);

        driver.findElement(By.id("about-link")).click();
        // Print the title of the new page
        System.out.println("About page title: " + driver.getTitle());

        // Close the browser
        driver.close();

        driver.quit();


    }
}
