package page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "http://pastebin.com/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='super_frame']")
    private WebElement superFrame;

    @FindBy(xpath = "//*[@id='paste_code']")
    private WebElement textFieldForNewPaste;

    @FindBy(name = "paste_format")
    private WebElement syntaxHighlighting;

    @FindBy(name = "paste_expire_date")
    private WebElement expiration;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement pasteName;

    @FindBy(name = "submit")
    private WebElement createNewPaste;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(createNewPaste));
        return this;
    }

    public PastebinHomePage fillInTextForNewPaste(String textForNewPaste) {
        textFieldForNewPaste.sendKeys(textForNewPaste);
        return this;
    }

    public PastebinHomePage selectSyntaxHighlighting(String value) {
        Select highlighting = new Select(syntaxHighlighting);
        highlighting.selectByValue(value);
        return this;
    }

    public PastebinHomePage selectPasteExpiration(String value) {
        List<WebElement> options = expiration.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getAttribute("value").equals(value)){
                options.get(i).click();
                break;
            }
        }
        return this;
    }

    public PastebinHomePage fillInNameForNewPaste(String name) {
        pasteName.sendKeys(name);
        return this;
    }

    public PastebinWithNewPastePage pushButtonCreateNewPaste() {
        createNewPaste.click();
        return new PastebinWithNewPastePage(driver);
    }

}
