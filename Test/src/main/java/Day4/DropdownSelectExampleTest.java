package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DropdownSelectExampleTest {
    public static void main(String[] args) throws InterruptedException {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //mo web
        driver.get("https://saucelabs.com/request-demo");

        WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));

        Select select = new Select(interestDropdown);

        //select.selectByIndex(6);

        select.selectByVisibleText("Test Analytics ");

        Thread.sleep(3000);
        driver.quit();



    }
}
