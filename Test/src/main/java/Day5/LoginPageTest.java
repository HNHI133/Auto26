package Day5;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import untils.ExcelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPageTest {

    public static void main(String[] args) throws InterruptedException {
        //Duong dan file excel
        String excelFilePath = "DataProduct.xlsx";
        String sheetName = "Sheet1";
        // doc du lieu tu file excel
        List<Map<String, String>> data = ExcelUtils.readExcelData(excelFilePath, sheetName);


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
// 2. Đăng nhập
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        try{
            for(Map<String, String> rowData : data) {
                System.out.println("Dữ liệu hàng: " + rowData);
                String product = rowData.get("username");
                //sử dụng nối chuỗi


                WebElement addToCard = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
                addToCard.sendKeys(product);


            }
        }
        finally {
            driver.quit();
        }

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        driver.quit();
    }

}
