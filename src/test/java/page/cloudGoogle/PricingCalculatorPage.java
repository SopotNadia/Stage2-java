package page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.cloudGoogle.fieldsOfCalculator.*;

public class PricingCalculatorPage {
    private WebDriver driver;
    private By commitedUsageBy = By.xpath("//*[@id='select_option_85']/div[contains(text(),'3 Year')]");

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and contains(@ng-disabled,'ComputeEngineForm')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage fillInFields() {
        new InstancesNumber(driver).fillInNumberOfInstances("4");
        new InstanceType(driver).selectInstanceType();
        GPUs currentGPUs = new GPUs(driver);
        currentGPUs.clickCheckBoxAddGPUs();
        currentGPUs.selectNumberOfGPUs();
        currentGPUs.selectGPUType();
        new LocalSSD(driver).selectLocalSSD();
        new DatacenterLocation(driver).selectDatacenterLocation();
        new CommittedUsage(driver).selectCommittedUsage();
        return this;
    }

    public EstimatedCostPage addToEstimate() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.invisibilityOfElementLocated(commitedUsageBy));
        addToEstimateButton.click();
        addToEstimateButton.click();
        return new EstimatedCostPage(driver);
    }
}
