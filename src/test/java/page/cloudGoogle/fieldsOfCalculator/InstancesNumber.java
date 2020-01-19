package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstancesNumber {
    private WebDriver driver;

    public InstancesNumber(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input_53']")
    private WebElement numberOfInstances;

    public InstancesNumber fillInNumberOfInstances(String value) {
        driver.switchTo().frame("myFrame");
        numberOfInstances.sendKeys(value);
        return this;
    }
}
