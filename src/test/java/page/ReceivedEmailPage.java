package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceivedEmailPage extends AbstractPage {
    private String actualResult;
    private String expectedResult;
    private By totalEstimatedCostBy = By.xpath("//h2[contains(text(),'Estimated Monthly Cost')]");
    private By dropDownEmailBy = By.xpath("//span[@class='inc-mail-address']");


    public ReceivedEmailPage(String actualResult) {
        super();
        this.actualResult = actualResult;
    }

    public ReceivedEmailPage openEmail() {
        WebElement dropDownEmail = new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(dropDownEmailBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dropDownEmail);
        dropDownEmail.click();
        WebElement totalEstimatedCost = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(totalEstimatedCostBy));
        expectedResult = totalEstimatedCost.getText();
        return this;
    }

    public boolean checkTotalEstimatedCost() {
        return expectedResult.contains(actualResult);
    }
}
