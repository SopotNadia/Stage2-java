package page.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinWithNewPastePage {
    private WebDriver driver;

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
        return writtenCode.getText().equals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force")
                && pasteName.getText().equals("how to gain dominance among developers")
                && syntax.getText().equals("Bash");
    }
}
