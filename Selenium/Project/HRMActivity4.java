import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HRMActivity4 extends BaseTest{

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void addNewEmployeeTest() throws Exception
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit =122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        String lastName = buffer.toString();
         String firstName="John";

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("btnSave")).click();
        driver.navigate().to("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewEmployeeList");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"))).sendKeys(firstName+" "+lastName);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();
        List<WebElement> rowsNumber = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[1]"));
        int rowCount = rowsNumber.size();
        System.out.println("No of rows in this table : " + rowCount);
        List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th"));
        int columnCount = columnsNumber.size();
        System.out.println("No of columns in this table : " + columnCount);

        if(rowCount==1)
        {

            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")).getText(),firstName);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]")).getText(),lastName);
        }else{

        for (int i =1;i<rowCount;i++)
        {
            String firstTemp= driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + (i+1)+ "]/td[3]")).getText();
            String lastTemp= driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
            if(firstTemp.equals(firstName)&&lastTemp.equals(lastName))
            {
                Assert.assertEquals(firstTemp,firstName);
                Assert.assertEquals(lastTemp,lastName);
            }
        }
        }

    }

    @AfterClass
    public void teardown() {
        driver.quit();

    }
}



