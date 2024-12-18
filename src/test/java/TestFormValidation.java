import base.DriverFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import pages.FormPage;
import pages.MainPage;

import java.net.MalformedURLException;


public class TestFormValidation {

    @Parameters({"browser"})
    @Test
    public void testMandatoryFieldsErrorMessages(String browser) throws MalformedURLException, InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        String baseURL = "https://qubika.com/";
        try {
            MainPage mainPage = new MainPage(driver);
            FormPage formPage = new FormPage(driver);
            driver.get(baseURL);

            String currentUrl = driver.getCurrentUrl();
            assert baseURL.compareToIgnoreCase(currentUrl)==0: "The url does not match the requested one.";
            assert mainPage.isLogoDisplayed(): "The logo is not present.";

            mainPage.clickContactUs();
            // Submit the form without filling any fields
            formPage.clickSubmit();

            // Validate error messages for all mandatory fields
            formPage.validateFieldsErrorMessages(false);
            formPage.enterFirstName("Test name");
            formPage.validateFieldsErrorMessages(true);

        } finally {
            driver.close();
        }
    }
}