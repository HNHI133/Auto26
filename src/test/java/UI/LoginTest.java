package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    String excelFilePath = "TestData.xlsx";

    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void setUp() {
        // Khởi tạo ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://saucedemo.com");
    }
    @Test
    public void testValidLogin() {
        // Test đăng nhập với thông tin hợp lệ
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Kiểm tra URL để xác nhận đăng nhập thành công
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Đăng nhập không thành công!");
    }
    @Test
    public void testInvalidLogin() {
        // Test đăng nhập với thông tin không hợp lệ
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        // Kiểm tra thông báo lỗi hiển thị
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"), "Thông báo lỗi không đúng!");
    }
    @AfterTest
    public void tearDown() {
        // Đóng trình duyệt sau khi chạy test xong
        if (driver != null) {
            driver.quit();
        }
    }



}
