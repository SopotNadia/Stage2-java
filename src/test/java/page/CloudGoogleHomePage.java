package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage extends AbstractPage {
    private final String HOMEPAGE_URL = "https://cloud.google.com/";
    private By searchButtonBy = By.xpath("//input[@aria-label='Окно поиска']");

    @FindBy(name = "q")
    private WebElement searchField;

    public CloudGoogleHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage open(){
        driver.get(HOMEPAGE_URL);
        WebElement searchButton = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(searchButtonBy));
        logger.info("Opened site (" + HOMEPAGE_URL + ")");
        searchButton.click();
        return this;
    }

    public SearchResultsPage searchForTerm(String term){
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage();
    }
}
