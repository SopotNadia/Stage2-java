package page;

import model.TestModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.fieldsOfCalculator.*;

public class PricingCalculatorPage extends AbstractPage {
    private By commitedUsageBy = By.xpath("//*[@id='select_option_85']/div[contains(text(),'3 Year')]");
    private String expectedResult;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and contains(@ng-disabled,'ComputeEngineForm')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage fillInFields(TestModel testModel) {
        new InstancesNumber().fillInNumberOfInstances(testModel.getNumberOfInstances());
        new InstanceType().selectInstanceType(testModel.getMachineType());
        GPUs currentGPUs = new GPUs();
        currentGPUs.clickCheckBoxAddGPUs();
        currentGPUs.selectNumberOfGPUs();
        currentGPUs.selectGPUType();
        new LocalSSD().selectLocalSSD();
        new DatacenterLocation().selectDatacenterLocation();
        new CommittedUsage().selectCommittedUsage();
        logger.info("All calculator fields filled in");
        expectedResult = testModel.getExpectedResult();
        return this;
    }

    public EstimatedCostPage addToEstimate() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.invisibilityOfElementLocated(commitedUsageBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToEstimateButton);
        return new EstimatedCostPage(expectedResult);
    }
}
