package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Reporter;

import java.util.logging.Level;

public class DriverListener implements WebDriverListener {
    private static final Logger LOGGER = LogManager.getLogger("Listener");

    @Override
    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        LOGGER.debug("Executing: "+script);

    }

    @Override
    public void afterSendKeys(Alert alert, String text) {
        LOGGER.log(Priority.INFO,"sent keys: "+text);
    }
}
