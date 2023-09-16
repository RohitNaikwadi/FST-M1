package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static examples.ActionsBase.doSwipe;

public class ActionExample {

    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setuUp() throws MalformedURLException {
        //Desired Capablities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //set Appium Server URL
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //init driver
        driver = new AndroidDriver(serverUrl, options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium/sliders");
    }

    @Test
    public void swipeTest()
    {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.SeekBar")));
        //get size of screen
        Dimension dim= driver.manage().window().getSize();
        //set start and end point
        Point start= new Point((int)(dim.getWidth()*.35),(int)(dim.getHeight()*.59));
        Point end= new Point((int)(dim.getWidth()*0.5),(int)(dim.getHeight()*.59));
        //perform swipe
        doSwipe(driver,start,end,5000);

       // String valumeText=

    }

}
