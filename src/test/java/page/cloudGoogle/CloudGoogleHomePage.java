package page.cloudGoogle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {
    private final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(id = "searchbox")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchField;

    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage open(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(searchButton));
        return this;
    }

    public SearchResultsPage searchForTerm(String term){
        searchButton.click();
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
