package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommittedUsage {
    private WebDriver driver;
    private By committedUsageBy = By.xpath("//*[@id='select_option_85']/div[contains(text(),'1 Year')]");
    private By datacenterLocationOsaka = By.xpath("//*[@id='select_option_185']/child::div[contains(text(),'Osaka')]");

    @FindBy(xpath = "//label[contains(text(),'Committed usage')]/following-sibling::md-select")
    private WebElement committedUsageContainerBy;

    public CommittedUsage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CommittedUsage selectCommittedUsage() {
         new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(datacenterLocationOsaka));
        committedUsageContainerBy.click();
        WebElement committedUsage = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(committedUsageBy));
        committedUsage.click();
        return this;
    }
}
