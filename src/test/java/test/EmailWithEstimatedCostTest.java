package test;

import model.TestModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleHomePage;
import service.TestModelCreator;

public class EmailWithEstimatedCostTest extends CommonConditions {

    @Test(description = "This test check whether total estimated cost from calculator equals total estimated cost from email", invocationCount = 1)
    public void receiveEmailWithEstimatedCost() {
        TestModel testModel = TestModelCreator.withCredentialsFromProperty();
        boolean result = new CloudGoogleHomePage()
                .open()
                .searchForTerm("Google Cloud Platform Pricing Calculator")
                .selectResultWithCalculator()
                .fillInFields(testModel)
                .addToEstimate()
                .pressEmailEstimateButton()
                .openNewTabInChromeWithTenMinuteEmailPage()
                .getEmailAddress()
                .sendEmail()
                .openEmail()
                .checkTotalEstimatedCost();

        Assert.assertTrue(result, "Total estimated cost from calculator doesn't equal total estimated cost from email");
    }
}
