package Feature.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Unhappycase {

    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Bước 1: Truy cập trang Book Your Demo
            driver.get("https://saucelabs.com/request-demo");
            driver.manage().window().maximize();

            // Bước 2: Test các trường hợp dữ liệu không hợp lệ

            // Test 1: Để trống trường Business Email
            WebElement emailField = driver.findElement(By.id("business_email"));
            emailField.clear(); // Xóa dữ liệu nếu có
            emailField.sendKeys(""); // Không nhập gì vào

            // Nhập dữ liệu vào các trường khác để đảm bảo valid
            driver.findElement(By.id("company")).sendKeys("Test Company");
            driver.findElement(By.id("phone_number")).sendKeys("123456789");
// Click vào Submit
            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), \"Let's Talk\")]"));
            submitButton.click();

            // Kiểm tra thông báo lỗi xuất hiện
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Business Email is required')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Test 1 Passed: Thông báo lỗi 'Business Email is required' hiển thị.");
            } else {
                System.out.println("Test 1 Failed: Không thấy thông báo lỗi.");
            }

            // Thêm các trường hợp khác như:
            // - Email không hợp lệ
            // - Thiếu các trường bắt buộc
            // - Số điện thoại chứa ký tự không hợp lệ
            // - Để trống nhiều trường cùng lúc

            // Test 2: Nhập email không hợp lệ
            emailField.sendKeys("invalidemail");
            submitButton.click();
            WebElement invalidEmailMessage = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email address')]"));
            if (invalidEmailMessage.isDisplayed()) {
                System.out.println("Test 2 Passed: Thông báo lỗi 'Invalid email address' hiển thị.");
            } else {
                System.out.println("Test 2 Failed: Không thấy thông báo lỗi email không hợp lệ.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
