package page.cloudGoogle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.cloudGoogle.fieldsOfCalculator.*;

public class PricingCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Estimate')]")
    private  WebElement addToEstimate;

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



}
