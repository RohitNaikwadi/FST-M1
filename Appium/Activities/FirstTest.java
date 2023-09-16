package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    AppiumDriver driver;


    @BeforeClass
    public void setuUp() throws MalformedURLException {
        //Desired Capablities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //set Appium Server URL
        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        //init driver
        driver = new AndroidDriver(serverUrl, options);
    }

    @Test
    public void additionTest() {
        //find 7 button and  click
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7")).click();

        //plus
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add")).click();
        //find and click 9 button
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        //find equal button
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        //get n assert result
        String result=driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
System.out.println(result);
        Assert.assertEquals("16",result);

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
