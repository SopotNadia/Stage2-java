package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GPUs {
    private WebDriver driver;

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

    public GPUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GPUs clickCheckBoxAddGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(checkBoxAddGPUs));
        checkBoxAddGPUs.click();
        return this;
    }

    public GPUs selectNumberOfGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(numberOfGPUsContainer));
        numberOfGPUsContainer.click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(numberOfGPUs));
        numberOfGPUs.click();
        return this;
    }

    public GPUs selectGPUType() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(GPUTypeContainer));
        GPUTypeContainer.click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(GPUType));
        GPUType.click();
        return this;
    }
}
