package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static examples.ActionsBase.doSwipe;

public class ProjectClass {
    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setuUp() throws MalformedURLException {
        //Desired Capablities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //set Appium Server URL
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //init driver
        driver = new AndroidDriver(serverUrl, options);

    }

    @Test
    public void googleTask() throws InterruptedException {
       driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id( "com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup")).getTagName(),"Complete Activity with Google Tasks");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText(),"Complete Activity with Google Keep");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText(),"Complete the second Activity Google Keep");
    }

}
