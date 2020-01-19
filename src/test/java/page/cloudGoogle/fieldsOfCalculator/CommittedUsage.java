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
    private final By COMMITTED_USAGE_CONTAINER = By.xpath("//label[contains(text(),'Committed usage')]/following-sibling::md-select");
    private final By COMMITTED_USAGE = By.xpath("//*[@id='select_option_85']/div[contains(text(),'1 Year')]");

    public CommittedUsage(WebDriver driver) {
        this.driver = driver;
    }

    public CommittedUsage selectCommittedUsage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement committedUsageContainer = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(COMMITTED_USAGE_CONTAINER));
        committedUsageContainer.click();
        WebElement committedUsage = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(COMMITTED_USAGE));
        committedUsage.click();
        return this;
    }
}
