package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.cloudGoogle.CloudGoogleHomePage;

public class HurtMePlentyTest {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetUp(){
        //System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "This test calculate ######################")
    public void calculate(){                // имя функции
        new CloudGoogleHomePage(driver)
                .open()
                .searchForTerm("Google Cloud Platform Pricing Calculator")
                .selectResultWithCalculator()
                .fillInFields();
    }

//    @AfterTest(alwaysRun = true)
//    public void closeBrowser() {
//        driver.quit();
//    }

}
