package page.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class LocalSSD extends AbstractPage {
    private By localSSDBy = By.xpath("//*[contains(text(),'2x375')]");
    private By GPUTypeNvidiaBy = By.xpath("//div[contains(text(),'NVIDIA Tesla T4')]");

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    private WebElement localSSDContainer;

    public LocalSSD() {
        super();
        PageFactory.initElements(driver, this);
    }

    public LocalSSD selectLocalSSD() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(GPUTypeNvidiaBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", localSSDContainer);
        WebElement localSSD = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(localSSDBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", localSSD);
        return  this;
    }
}
