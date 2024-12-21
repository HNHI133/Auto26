package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import untils.ExcelUtils;

import java.util.List;
import java.util.Map;

public class AddToCardTest {
    public static void main(String[] args) throws InterruptedException {
        //Duong dan file excel
        String excelFilePath = "dataLogin.xlsx";
        String sheetName = "Sheet1";
        // doc du lieu tu file excel
        List<Map<String, String>> data = ExcelUtils.readExcelData(excelFilePath, sheetName);


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
