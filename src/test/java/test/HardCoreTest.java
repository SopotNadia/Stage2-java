package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.cloudGoogle.CloudGoogleHomePage;

public class HardCoreTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "This test check whether total estimated cost from calculator equals total estimated cost from email", invocationCount = 1)
    public void receiveEmailWithEstimatedCost() {
        boolean result = new CloudGoogleHomePage(driver)
                .open()
                .searchForTerm("Google Cloud Platform Pricing Calculator")
                .selectResultWithCalculator()
                .fillInFields()
                .addToEstimate()
                .pressEmailEstimateButton()
                .openNewTabInChromeWithTenMinuteEmailPage()
                .getEmailAddress()
                .sendEmail()
                .openEmail()
                .checkTotalEstimatedCost();

        Assert.assertTrue(result, "Total estimated cost from calculator doesn't equal total estimated cost from email");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
