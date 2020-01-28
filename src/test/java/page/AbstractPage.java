package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Logger logger;

    public AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        this.logger = LogManager.getRootLogger();
    }
}
