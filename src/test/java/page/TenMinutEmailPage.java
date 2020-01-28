package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutEmailPage extends AbstractPage {
    private By emailAddressBy = By.id("mailAddress");

    public TenMinutEmailPage() {
        super();
    }

    public EmailYourEstimateForm getEmailAddress() {
        String emailAddress = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(emailAddressBy)).getAttribute("value");
        TabSwitcher.switchTab(driver, 0);
        return new EmailYourEstimateForm(emailAddress);
    }

}
