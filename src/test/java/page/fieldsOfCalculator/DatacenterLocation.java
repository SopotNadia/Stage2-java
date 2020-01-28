package page.fieldsOfCalculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class DatacenterLocation extends AbstractPage {
    private By datacenterLocationBy = By.xpath("//*[@id='select_option_181']");
    private By localSSDBy = By.xpath("//*[contains(text(),'8x375')]");

    @FindBy(xpath = "//label[contains(text(),'Datacenter location')]/following-sibling::md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationContainer;

    public DatacenterLocation() {
        super();
        PageFactory.initElements(driver, this);
    }

    public DatacenterLocation selectDatacenterLocation() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(localSSDBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", datacenterLocationContainer);
        WebElement datacenterLocation = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(datacenterLocationBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", datacenterLocation);
        return this;
    }
}
