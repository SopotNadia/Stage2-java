package page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailYourEstimateForm {
    private WebDriver driver;
    private final String TEN_MINUTEMAIL_PAGE = " https://10minutemail.com";
    private String email;
    private By emailFieldBy = By.xpath("//input[@ng-model='emailQuote.user.email']");
    private By sendEmailBy = By.xpath("//button[@aria-label='Send Email']");

    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement totalEstimatedCostElement;

    public EmailYourEstimateForm(WebDriver driver) {
        this.driver = driver;
    }

    public EmailYourEstimateForm(WebDriver driver, String email) {
        this.driver = driver;
        this.email = email;
        PageFactory.initElements(driver, this);
    }

    public TenMinutEmailPage openNewTabInChromeWithTenMinuteEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        TabSwitcher.switchTab(driver, 1);
        driver.navigate().to(TEN_MINUTEMAIL_PAGE);
        return new TenMinutEmailPage(driver);
    }

    public ReceivedEmailPage sendEmail() {
        driver.switchTo().frame("myFrame");
        WebElement emailField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(emailFieldBy));
        emailField.sendKeys(email);
        WebElement sendEmailButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sendEmailBy));
        sendEmailButton.click();
        String actualResult = totalEstimatedCostElement.getText()
                .replace("Estimated Component Cost: ", "").replace(" per 1 month", "");
        TabSwitcher.switchTab(driver, 1);
        return new ReceivedEmailPage(driver, actualResult);
    }
}
