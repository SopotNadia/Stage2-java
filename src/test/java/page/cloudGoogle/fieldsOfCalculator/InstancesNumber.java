package page.cloudGoogle.fieldsOfCalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstancesNumber {
    private WebDriver driver;

    @FindBy(id = "input_53")
    private WebElement numberOfInstances;

    @FindBy(id = "myFrame")
    private WebElement iFrame;


    public InstancesNumber(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InstancesNumber fillInNumberOfInstances(String value) {
        driver.switchTo().frame(iFrame);
        numberOfInstances.sendKeys(value);
        return this;
    }
}
