package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.cloudGoogle.CloudGoogleHomePage;
import page.cloudGoogle.EstimatedCostPage;

public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "This test checks input fields and calculation of cloud computer price", invocationCount=2)
    public void calculateVM(){
        boolean expectedResults = new CloudGoogleHomePage(driver)
                .open()
                .searchForTerm("Google Cloud Platform Pricing Calculator")
                .selectResultWithCalculator()
                .fillInFields()
                .addToEstimate()
                .checkFieldsAndPriceOfEstimatedCost();

        Assert.assertTrue(expectedResults, EstimatedCostPage.getMessageAboutExpectedResults().toString());
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
