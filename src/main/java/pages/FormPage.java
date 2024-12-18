package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.List;

public class FormPage {

    private final WebDriver driver;

    // Locators for the Login page
    private By contentForm = By.xpath("//div[@class='modal-content hubspot-form']");
    private By firstNameField = By.xpath("//input[@name='firstname']");
    private By lastNameField = By.xpath("//input[@name='lastname']");
    private By emailField = By.xpath("//input[@name='email']");
    private By companyNameField = By.xpath("//input[@name='company']");
    private By contactTypeField = By.xpath("//select[@name='contact_type']");
    private By messageField = By.xpath("//textarea[@name='message']");
    private By firstNameErrorMessage = By.xpath("//div[@class='hs_firstname hs-firstname hs-fieldtype-text field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By lastNameFieldErrorMessage = By.xpath("//div[@class='hs_lastname hs-lastname hs-fieldtype-text field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By emailFieldErrorMessage = By.xpath("//div[@class='hs_email hs-email hs-fieldtype-text field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By companyNameFieldErrorMessage = By.xpath("//div[@class='hs_company hs-company hs-fieldtype-text field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By contactTypeFieldErrorMessage = By.xpath("//div[@class='hs_contact_type hs-contact_type hs-fieldtype-select field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By messageFieldErrorMessage = By.xpath("//div[@class='hs_message hs-message hs-fieldtype-textarea field hs-form-field']/ul[@class='no-list hs-error-msgs inputs-list']");
    private By submitButton = By.xpath("//input[@class='hs-button primary large']");


    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

//    public FormPage goToFormPage(String url) {
//        driver.get(url);
//        return this;
//    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickContentForm() {
        driver.findElement(contentForm).click();
    }

    // Actions on the page
    public void enterFirstName(String username) {
        driver.findElement(firstNameField).sendKeys(username);
    }

    public void enterLastName(String password) {
        driver.findElement(lastNameField).sendKeys(password);
    }

    public void clickSubmit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }

    public void validateFieldsErrorMessages(boolean firstNamePresent) {
        if (firstNamePresent) {
            assert !getErrorMessageForField(firstNameErrorMessage): "Error message for first name is present";
        } else {
            assert getErrorMessageForField(firstNameErrorMessage): "Error message for first name is missing";
        }
        assert getErrorMessageForField(lastNameFieldErrorMessage): "Error message for last name is missing";
        assert getErrorMessageForField(emailFieldErrorMessage): "Error message for email is missing";
        assert getErrorMessageForField(companyNameFieldErrorMessage): "Error message for company name is missing";
        assert getErrorMessageForField(contactTypeFieldErrorMessage): "Error message for contact type is missing";
        assert getErrorMessageForField(messageFieldErrorMessage): "Error message for message is missing";
    }

    public boolean getErrorMessageForField(By field) {
        boolean found = false;
        List<WebElement> errorElement = driver.findElements(field);
        if (errorElement.size()>0) {
            found = errorElement.get(0).isDisplayed();
        }
        return found;
    }

}