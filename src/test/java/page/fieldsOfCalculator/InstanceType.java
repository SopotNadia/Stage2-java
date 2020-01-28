package page.fieldsOfCalculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class InstanceType extends AbstractPage {
    private By instanceTypeBy;
    private By instanceTypeContainerBy = By.xpath("//label[contains(text(),'Machine type')]/following-sibling::md-select");

    public InstanceType() {
        super();
    }

    public InstanceType selectInstanceType(String value) {
        WebElement instanceTypeContainer = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(instanceTypeContainerBy));
        instanceTypeContainer.sendKeys(Keys.ENTER);
        instanceTypeBy = By.xpath(String.format("//md-option/div[contains(text(),'%s')]", value));
        WebElement instanceType = new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(instanceTypeBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", instanceType);
        return this;
    }
}
