package page.cloudGoogle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage selectResultWithCalculator() {
        searchResults.get(0).click();
        return new PricingCalculatorPage(driver);
    }
}
