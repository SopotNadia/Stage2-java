package page.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class InstancesNumber extends AbstractPage {
    @FindBy(id = "input_53")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//iframe")
    private WebElement firstFrame;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    public InstancesNumber() {
        super();
        PageFactory.initElements(driver, this);
    }

    public InstancesNumber fillInNumberOfInstances(String value) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(myFrame);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='What are these instances for?']")));
        numberOfInstances.sendKeys(value);
        return this;
    }
}
