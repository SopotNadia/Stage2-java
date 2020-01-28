package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResult;

    public SearchResultsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage selectResultWithCalculator() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(searchResult));
        searchResult.click();
        logger.info("Search completed");
        return new PricingCalculatorPage();
    }
}
