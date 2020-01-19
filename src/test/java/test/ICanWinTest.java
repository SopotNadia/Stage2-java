package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.pastebin.PastebinHomePage;

public class ICanWinTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "this test creates a new paste on https://pastebin.com/")
    public void createNewPaste() {
        WebElement expectedElement = new PastebinHomePage(driver)
                .openPage()
                .fillInTextForNewPaste("Hello from WebDriver")
                .selectPasteExpiration("10M")
                .fillInNameForNewPaste("helloweb")
                .pushButtonCreateNewPaste()
                .searchExpectedElementOnPageWithNewPaste();

        Assert.assertNotNull(expectedElement, "The paste wasn't created");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
