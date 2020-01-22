package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstanceType {
    private WebDriver driver;
    private By instanceTypeBy = By.xpath("//md-option/div[contains(text(),'standard-8')]");
    private By instanceTypeContainerBy = By.xpath("//label[contains(text(),'Machine type')]/following-sibling::md-select");

    public InstanceType(WebDriver driver) {
        this.driver = driver;
    }

    public InstanceType selectInstanceType() {
        WebElement instanceTypeContainer = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(instanceTypeContainerBy));
        instanceTypeContainer.click();
        WebElement instanceType = new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(instanceTypeBy));
        instanceType.click();
        return this;
    }
}
