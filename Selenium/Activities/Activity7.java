package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title" + pageTitle);

        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();

        String textTo = to.getText();
//System.out.println(textTo);
        if(textTo.contains("Dropped!")) {
            System.out.println("PASS Dropzone1");
            WebElement fromDropzone1=to;
            WebElement toDropzone2 = driver.findElement(By.id("dropzone2"));
            builder.dragAndDrop(fromDropzone1, toDropzone2).perform();
            String textToDropzone2 = toDropzone2.getText();
            if(textTo.contains("Dropped!")) {
            System.out.println("PASS Dropzone2");

            }
            else{
                System.out.println("FAIL Dropzone 2");

            }


        }else {
            System.out.println("FAIL Dropzone 1");
        }

        driver.quit();

    }

}
