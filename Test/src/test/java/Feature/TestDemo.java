package Feature;

import UI.RequestDemoPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {
    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;

    public TestDemo(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        TestDemo testDemo = new TestDemo(driver);

        testDemo.requestDemoPageUI.findBusinessEmailInput().sendKeys("thaontp.la@gmail.com");
        testDemo.requestDemoPageUI.findFirstNameInput().sendKeys("Thao");
        testDemo.requestDemoPageUI.findLastNameInput().sendKeys("Nguyen Thi Phuong");
        testDemo.requestDemoPageUI.findCompanyInput().sendKeys("Techcombank");
        testDemo.requestDemoPageUI.findPhoneNumberInput().sendKeys("121121212");
        testDemo.requestDemoPageUI.findCountryDropdown().sendKeys("Vietnam");
        testDemo.requestDemoPageUI.findInterestDropdown().sendKeys("Scalable Test Automation");
        testDemo.requestDemoPageUI.findCommentsTextArea().sendKeys("We can walk you through a custom demo");
        testDemo.requestDemoPageUI.findCheckbox().click();
        testDemo.requestDemoPageUI.findSubmitButton().click();

        driver.quit();
    }
}
