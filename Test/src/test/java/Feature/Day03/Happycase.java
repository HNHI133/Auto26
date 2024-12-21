package Feature.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Happycase {

    public static void main(String[] args) {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        try {
            // Bước 1: Truy cập trang Book Your Demo
            driver.get("https://saucelabs.com/request-demo");
            driver.manage().window().maximize();

            // Bước 2: Điền thông tin vào các trường required
            // Nhập vào Business Email
            WebElement emailField = driver.findElement(By.id("business_email")); // Thay id thực tế
            emailField.sendKeys("test@example.com");

            // Nhập vào Company
            WebElement companyField = driver.findElement(By.id("company")); // Thay id thực tế
            companyField.sendKeys("Công ty Test");

            // Chọn Interest từ dropdown
            WebElement interestDropdown = driver.findElement(By.id("interest")); // Thay id thực tế
            Select selectInterest = new Select(interestDropdown);
            selectInterest.selectByVisibleText("API Testing"); // Chọn giá trị phù hợp

            // (Optional) Nhập Comments
            WebElement commentsField = driver.findElement(By.id("comments")); // Thay id thực tế
            commentsField.sendKeys("Đây là comment cho test case Happy Case.");

            // Tích checkbox (nếu có)
            WebElement checkbox = driver.findElement(By.id("agreement_checkbox")); // Thay id thực tế
            checkbox.click();

            // Bước 3: Nhấn nút Submit (Let's Talk)
            WebElement submitButton = driver.findElement(By.id("submit_button")); // Thay id thực tế
            submitButton.click();

            // Bước 4: Xác minh kết quả
            WebElement successMessage = driver.findElement(By.id("success_message")); // Thay id thực tế
            if (successMessage.isDisplayed()) {
                System.out.println("Happy Case Passed: Form gửi thành công!");
            } else {
                System.out.println("Happy Case Failed: Không tìm thấy thông báo thành công.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
