package Feature.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScripExcutorExampleTest {
    public static void main(String[] args) throws InterruptedException {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value = 'Visual Testing';", interestDropdown);

        String selectedValue = interestDropdown.getAttribute("value");
        System.out.println("Selected value: " + selectedValue);

    }
}
