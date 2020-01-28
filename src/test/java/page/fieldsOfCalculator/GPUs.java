package page.fieldsOfCalculator;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class GPUs extends AbstractPage {
    private By instanceTypeBy = By.xpath("//md-option/div[contains(text(),'standard-8')]");

    @FindBy(xpath = "//div[@class='md-container md-ink-ripple']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//label[contains(text(),'Number of GPUs')]//following-sibling::md-select")
    private WebElement numberOfGPUsContainer;

    @FindBy(xpath = "//div[contains(text(),'1') and @class='md-text ng-binding']/parent::md-option[@value='1' and contains(@ng-repeat,'supportedGpuNumbers')]")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//label[contains(text(),'GPU type')]/following-sibling::md-select")
    private WebElement GPUTypeContainer;

    @FindBy(xpath = "//*[contains(text(),'V100')]")
    private WebElement GPUType;

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    private WebElement localSSDContainer;

    public GPUs() {
        super();
        PageFactory.initElements(driver, this);
    }

    public GPUs clickCheckBoxAddGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(instanceTypeBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBoxAddGPUs);
        return this;
    }

    public GPUs selectNumberOfGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(numberOfGPUsContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGPUsContainer);
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(numberOfGPUs));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGPUs);
        return this;
    }

    public GPUs selectGPUType() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(GPUTypeContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GPUTypeContainer);
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(GPUType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GPUType);
        return this;
    }
}
