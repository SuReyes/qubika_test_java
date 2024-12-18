package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    // Locators for the Login page
    private By qubikaLogo = By.xpath("//a[@class='logo']");
    private By contactUs = By.xpath("//li[@class='menu-item menu-item-contact-us contact-us-main-menu-button contact-us-modal-open']/a");
    private By contentForm = By.xpath("//div[@class='modal-content hubspot-form']");

    // Actions on the page
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(qubikaLogo).isDisplayed();
    }

    public void clickContactUs() {
        driver.findElement(contactUs).click();
    }

    public void clickContentForm() {
        driver.findElement(contentForm).click();
    }
}


