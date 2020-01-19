package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalSSD {
    private WebDriver driver;
    private final By LOCAL_SSD_CONTAINER =By.xpath("//label[contains(text(),'Local SSD')]/following-sibling::md-select");
    private final By LOCAL_SSD = By.xpath("//*[contains(text(),'2x375')]");

    public LocalSSD(WebDriver driver) {
        this.driver = driver;
    }

    public LocalSSD selectLocalSSD() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement localSSDContainer = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(LOCAL_SSD_CONTAINER));
        localSSDContainer.click();
        WebElement localSSD = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(LOCAL_SSD));
        localSSD.click();
        return  this;
    }
}
