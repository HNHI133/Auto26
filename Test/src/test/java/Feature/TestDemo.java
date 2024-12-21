package Feature;

import UI.RequestDemoPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.util.List;

public class TestDemo {
    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;

    public TestDemo(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://saucelabs.com/request-demo");
//
//        //Tìm phần tử theo CSS Selector: tất cả ca nút button
//        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
//        System.out.println("\nButtons: " );
//        for (WebElement button : buttons) {
//            System.out.println(button.getText());
//        }
//        //Tìm phần tử theo CSS Selector: input có name là "email"
//        WebElement emailInput = driver.findElement(By.cssSelector("input[name=email]"));
//        emailInput.sendKeys("test@example.com");
//        driver.quit();
//
//        //


        driver.get("https://demo.guru99.com/test/upload/");

        String filePath = "D:/JAVA AUTO/Auto/Hello Word_Selenium.txt";

        WebElement uploadFile = driver.findElement(By.id("uploadFile_0"));
        uploadFile.sendKeys(filePath);

        WebElement termsCheckbox = driver.findElement(By.id("terms"));
        termsCheckbox.click();

        WebElement uploadButton = driver.findElement(By.id("submitButton"));
        uploadButton.click();

        Thread.sleep(5000);

        WebElement resultMessage = driver.findElement(By.id("res"));
        System.out.println("Kết quả tải lên: " + resultMessage.getText());

        driver.quit();

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
