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

public class CartTest {
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
    public void testAddToCart() {
            //Duong dan file excel
            String excelFilePath = "TestData.xlsx";
            String sheetName = "Sheet1";
            // doc du lieu tu file excel
            List<Map<String, String>> data = ExcelUtils.readExcelData(excelFilePath, sheetName);


            // Code đăng nhập và thêm sản phẩm vào giỏ hàng...
        // Thực hiện test logic thêm vào giỏ hàng ở đây.
    }
    @AfterTest
    public void tearDown() throws IOException {
        ExcelUtils.closeFile(excelFilePath);
        driver.quit();
    }

}
