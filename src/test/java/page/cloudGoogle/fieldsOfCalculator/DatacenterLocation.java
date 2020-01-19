package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatacenterLocation {
    private WebDriver driver;
    private final By DATACENTER_LOCATION_CONTAINER = By.xpath("//label[contains(text(),'Datacenter location')]/following-sibling::md-select[@ng-model='listingCtrl.computeServer.location']");
    private final By DATACENTER_LOCATION = By.xpath("//*[@id='select_option_181']");

    public DatacenterLocation(WebDriver driver) {
        this.driver = driver;
    }

    public DatacenterLocation selectDatacenterLocation() {
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
        WebElement datacenterLocationContainer = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(DATACENTER_LOCATION_CONTAINER));
        datacenterLocationContainer.click();
        WebElement datacenterLocation = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(DATACENTER_LOCATION));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView",datacenterLocation);
        datacenterLocation.click();
        return this;
    }
}
