package page.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinWithNewPastePage {
    private WebDriver driver;
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private final String SYNTAX = "Bash";

    public static String getCODE() {
        return CODE;
    }

    public static String getPASTE_NAME() {
        return PASTE_NAME;
    }

    @FindBy (xpath = "//*[@id='success']")
    private WebElement expectedElement;

    @FindBy (xpath = "//*[@id='paste_code']")
    private WebElement writtenCode;

    @FindBy (xpath = "//div[@class='paste_box_line1']")
    private WebElement pasteName;

    @FindBy (xpath = "//a[@href='/archive/bash']")
    private WebElement syntax;

    public PastebinWithNewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement searchExpectedElementOnPageWithNewPaste(){
        return expectedElement;
    }

    public boolean checkResultsOnPageWithNewPaste(){
        return writtenCode.getText().equals(CODE)
                && pasteName.getText().equals(PASTE_NAME)
                && syntax.getText().equals(SYNTAX);
    }
}
