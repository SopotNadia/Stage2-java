package test;

import model.TestModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudGoogleHomePage;
import service.TestModelCreator;

public class CalculateEstimatedCostTest extends CommonConditions {

    @Test(description = "This test check whether total estimated cost from calculator equals total estimated cost from manual test (1082,77)", invocationCount = 1)
    public void getEstimatedCostFromCalculator() {
        TestModel testModel = TestModelCreator.withCredentialsFromProperty();
        boolean result = new CloudGoogleHomePage()
                .open()
                .searchForTerm("Google Cloud Platform Pricing Calculator")
                .selectResultWithCalculator()
                .fillInFields(testModel)
                .addToEstimate()
                .checkEstimatedCost();

        Assert.assertTrue(result, "Total estimated cost from calculator doesn't equal expected estimated cost (1,082.77)");
    }
}