package page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EstimatedCostPage {
    private final String EXPECTED_ESTIMATION_COST = "1,082.77";
    private final String EXPECTED_VM = "regular";
    private final String EXPECTED_INSTANCE_TYPE = "n1-standard-8";
    private final String EXPECTED_REGION = "Frankfurt";
    private final String EXPECTED_LOCAL_SSD = "2x375";
    private final String EXPECTED_COMMITMENT_TERM = "1 Year";
    private WebDriver driver;
    private static StringBuilder messageAboutExpectedResults = new StringBuilder();

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement totalEstimatedCostElement;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding']/parent::md-list-item[contains(@ng-if,'class')]")
    private WebElement VMClassElement;

    @FindBy(xpath = "//*[contains(text(),'Instance type')]")
    private  WebElement instanceTypeElement;

    @FindBy(xpath = "//div[contains(text(),'Region')]")
    private WebElement regionElement;

    @FindBy(xpath = "//div[contains(text(),'local SSD')]")
    private WebElement localSSDElement;

    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTermElement;

    public EstimatedCostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static StringBuilder getMessageAboutExpectedResults() {
        return messageAboutExpectedResults;
    }

    public boolean checkFieldsAndPriceOfEstimatedCost() {
        boolean expectedResults = true;
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("email_quote")));

        String VMClass = VMClassElement.getText();
        if(VMClass.contains(EXPECTED_VM)){
            messageAboutExpectedResults.append(String.format("VM class is true (%s) \n", EXPECTED_VM));
        } else{
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("VM class is false (not %s) \n", EXPECTED_VM));
        }

        String instanceType = instanceTypeElement.getText();
        if(instanceType.contains(EXPECTED_INSTANCE_TYPE)){
            messageAboutExpectedResults.append(String.format("Instance type is true (%s) \n", EXPECTED_INSTANCE_TYPE));
        } else {
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("Instance type is false (not %s) \n", EXPECTED_INSTANCE_TYPE));
        }

        String region = regionElement.getText();
        if(region.contains(EXPECTED_REGION)){
            messageAboutExpectedResults.append(String.format("Region is true (%s) \n", EXPECTED_REGION));
        } else {
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("Region is false (not %s) \n", EXPECTED_REGION));
        }

        String localSSD = localSSDElement.getText();
        if(localSSD.contains(EXPECTED_LOCAL_SSD)){
            messageAboutExpectedResults.append(String.format("Local SSD is true (%s) \n", EXPECTED_LOCAL_SSD));
        }else {
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("Local SSD is false (not %s) \n", EXPECTED_LOCAL_SSD));
        }

        String commitmentTerm = commitmentTermElement.getText();
        if(commitmentTerm.contains(EXPECTED_COMMITMENT_TERM)){
            messageAboutExpectedResults.append(String.format("Commitment term is true (%s) \n", EXPECTED_COMMITMENT_TERM));
        }else{
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("Commitment term is false (not %s) \n", EXPECTED_COMMITMENT_TERM));
        }

        String totalEstimatedCost =  totalEstimatedCostElement.getText();
        if(totalEstimatedCost.contains(EXPECTED_ESTIMATION_COST)) {
            messageAboutExpectedResults.append(String.format("Rent sum per month equals rent sum from manual test (%s) \n", EXPECTED_ESTIMATION_COST));
        } else {
            expectedResults = false;
            messageAboutExpectedResults.append(String.format("\nRent sum per month doesn't  equal rent sum from manual test (%s) \n",EXPECTED_ESTIMATION_COST));
        }
        return expectedResults;
    }
}
