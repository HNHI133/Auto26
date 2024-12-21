package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExampleTest {
    public static void main(String[] args) throws InterruptedException {


    // Khởi tạo WebDriver
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://saucelabs.com/request-demo");

    //Tao doi tuong wait 15s

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    //Cho cho phan tu Email xuat hien
    WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
    firstNameField.sendKeys("Nhi@gmail.com");

    //cho cho nut submit co the nhap

    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("//button[contains(text(), \"Let's Talk\")]")));
    submitButton.click();

    //dong trinh duyet

    driver.quit();
}
}






