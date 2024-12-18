package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.net.MalformedURLException;
import java.util.Map;


public class DriverFactory {
    public static String FIREFOX = "firefox";
    public static String FIREFOX_LOCAL = "firefox_local";
    public static String CHROME = "chrome";
    public static String CHROME_LOCAL = "chrome_local";
    private static Map<String, AbstractDriverOptions> driverOptionsMap;

//    private static void initCapabilities() {
//        driverOptionsMap = new HashMap<>();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        driverOptionsMap.put(FIREFOX, firefoxOptions);
//        driverOptionsMap.put(CHROME, chromeOptions);
//    }
    public static WebDriver getDriver(String driverName) throws MalformedURLException {
        WebDriver driver;
        if (driverName.equalsIgnoreCase(FIREFOX_LOCAL)) {
            driver = new FirefoxDriver();
        } else if (driverName.equalsIgnoreCase(CHROME_LOCAL)) {
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Unsoported driver, options are firefox_local and chrome_local");
        }

        return driver;
    }
}
