package com.qa.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Pages.ExplorePage;
import com.qa.Pages.HomePage;
import com.qa.Pages.ReservationPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Testbase {
    public static WebDriver driver;
    public static JavascriptExecutor jse;
    public static WebDriverWait wait;
    public static TakesScreenshot takescreenshot;
    public static HomePage homepage;
    public static ExplorePage explorepage;
    public static ReservationPage reservationpage;


    @SuppressWarnings("deprecation")
    @Parameters({"Browser", "Url"})
    @BeforeClass 
    public void setup (String Browser,String Url){
        if (Browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); 
        } else if(Browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();            
        }
        driver.manage().window().maximize();
        driver.get(Url);
        homepage = new HomePage(driver);
        explorepage = new ExplorePage(driver);
        reservationpage = new ReservationPage(driver);
        jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        takescreenshot = (TakesScreenshot)driver;
    } 
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void screenShort(WebDriver driver2, String string) throws IOException {
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String screenshotName = "ScreenShort_" + timestamp + ".png";
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destinationFile = new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
    FileUtils.copyFile(screenshot, destinationFile);
    System.out.println("Screenshot saved: " + destinationFile.getAbsolutePath());
}


}
