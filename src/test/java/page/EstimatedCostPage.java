package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EstimatedCostPage extends AbstractPage {
    private final String EXPECTED_ESTIMATION_COST;
    private By estimateCurrencyFieldBy = By.xpath("//*[text()='USD - US Dollar']");

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement totalEstimatedCostElement;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding']/parent::md-list-item[contains(@ng-if,'class')]")
    private WebElement VMClassElement;

    @FindBy(xpath = "//*[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    public EstimatedCostPage(String expectedResult) {
        super();
        this.EXPECTED_ESTIMATION_COST = expectedResult;
        PageFactory.initElements(driver, this);
    }

    public EmailYourEstimateForm pressEmailEstimateButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(estimateCurrencyFieldBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", VMClassElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailEstimateButton);
        return new EmailYourEstimateForm();
    }

    public boolean checkEstimatedCost() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(estimateCurrencyFieldBy));
        String actualEstimatedCost = totalEstimatedCostElement.getText();
        return actualEstimatedCost.contains(EXPECTED_ESTIMATION_COST);
    }
}
