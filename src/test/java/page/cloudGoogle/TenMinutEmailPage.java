package page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutEmailPage {
    private WebDriver driver;
    private By emailAddressBy = By.id("mailAddress");

    public TenMinutEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailYourEstimateForm getEmailAddress() {
        String emailAddress = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(emailAddressBy)).getAttribute("value");
        TabSwitcher.switchTab(driver, 0);
        return new EmailYourEstimateForm(driver, emailAddress);
    }

}
