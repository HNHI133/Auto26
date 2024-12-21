package Feature.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MultiCheckboxSelectionTest {

    public static void main(String[] args) throws InterruptedException {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/radio.html");


        //Tim danh sach cac check box
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxes.add(driver.findElement(By.id("vfb-6-1")));
        checkboxes.add(driver.findElement(By.id("vfb-6-0")));

        //click vao tung checkbox va in ra
        for(WebElement checkbox : checkboxes) {
            checkbox.click();
            System.out.println("Checkbox value selected:" + checkbox.getAttribute("value"));
        }

        //dong
        Thread.sleep(2000);
        driver.quit();



    }
}
