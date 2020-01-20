package test;

import org.testng.Assert;
import page.pastebin.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.pastebin.PastebinWithNewPastePage;

public class BringItOnTest {
    public WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "this test creates a new paste on https://pastebin.com/")
    public void createNewOtherPaste() {
        boolean expectedResults = new PastebinHomePage(driver).openPage()
                .fillInTextForNewPaste(PastebinWithNewPastePage.getCODE())
                .selectSyntaxHighlighting("8")
                .selectPasteExpiration("10M")
                .fillInNameForNewPaste(PastebinWithNewPastePage.getPASTE_NAME())
                .pushButtonCreateNewPaste()
                .checkResultsOnPageWithNewPaste();

        Assert.assertTrue(expectedResults);
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
