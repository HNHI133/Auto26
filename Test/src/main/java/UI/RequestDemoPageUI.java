package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestDemoPageUI {
    private WebDriver driver;

    public RequestDemoPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findBusinessEmailInput() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Business Email')]/following-sibling::input"));
    }

    public WebElement findFirstNameInput() {
        return driver.findElement(By.xpath("//label[contains(text(), 'First Name')]/following-sibling::input"));
    }

    public WebElement findLastNameInput() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Last Name')]/following-sibling::input"));
    }

    public WebElement findCompanyInput() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Company')]/following-sibling::input"));
    }

    public WebElement findPhoneNumberInput() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Phone Number')]/following-sibling::input"));
    }

    public WebElement findCountryDropdown() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Country')]/following-sibling::select"));
    }

    public WebElement findInterestDropdown() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Interest')]/following-sibling::select"));
    }

    public WebElement findCommentsTextArea() {
        return driver.findElement(By.xpath("//label[contains(text(), 'Comments')]/following-sibling::textarea"));
    }

    public WebElement findCheckbox() {
        return driver.findElement(By.xpath("//input[@type='checkbox']"));
    }

    public WebElement findSubmitButton() {
        return driver.findElement(By.xpath("//button[contains(text(), \"Let's Talk\")]"));
    }
}
