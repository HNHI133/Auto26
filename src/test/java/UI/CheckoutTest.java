package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import untils.ExcelUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckoutTest {
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
    public void testCheckoutProcess() throws IOException {
        // Đường dẫn file Excel và tên sheet
        String excelFilePath = "TestData.xlsx";
        String sheetName = "Sheet1";

        // Đọc dữ liệu từ file Excel
        List<Map<String, String>> data = ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Lấy thông tin từ dòng đầu tiên
        String username = data.get(0).get("username"); // Cột "password" trong Excel
        String password = data.get(0).get("password"); // Cột "password" trong Excel

        System.out.println("Username: " + username + ", Password: " + password);

        // Code đăng nhập với username và password...
        // Ví dụ:
        login(username, password);

        // Thực hiện quy trình thanh toán
        // Giả sử bạn thêm sản phẩm vào giỏ hàng, kiểm tra tổng tiền, và thanh toán
        addToCart("Product1", 1); // Thêm sản phẩm vào giỏ
        proceedToCheckout(); // Tiến hành thanh toán
        completePayment(); // Hoàn tất thanh toán

        // Kiểm tra kết quả sau thanh toán (ví dụ: kiểm tra trang xác nhận)
        verifyOrderConfirmation();
    }

    // Các phương thức giả lập cho quy trình thanh toán
    public void login(String username, String password) {
        System.out.println("Logging in with Username: " + username + " and Password: " + password);
        // Thực hiện đăng nhập tại đây
    }

    public void addToCart(String product, int quantity) {
        System.out.println("Adding " + quantity + " of " + product + " to the cart.");
        // Thực hiện thêm sản phẩm vào giỏ hàng tại đây
    }

    public void proceedToCheckout() {
        System.out.println("Proceeding to checkout...");
        // Thực hiện quy trình thanh toán tại đây
    }

    public void completePayment() {
        System.out.println("Completing the payment...");
        // Thực hiện thanh toán tại đây
    }

    public void verifyOrderConfirmation() {
        System.out.println("Verifying order confirmation...");
        // Kiểm tra kết quả thanh toán tại đây
    }
}
