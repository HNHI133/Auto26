package Feature.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleRadioButtonSelectionTest {
    public static void main(String[] args) throws InterruptedException {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/radio.html");
//Tim radiobutton
        WebElement radioButton = driver.findElement(By.id("vfb-7-2"));

        //click
        radioButton.click();

        //Lay gia tri va trang thai cua radio button
        String value = radioButton.getAttribute("value");

        boolean isSelected = radioButton.isSelected();

        System.out.println("Radio button value is: " + value);
        System.out.println("Radio button is Selected: " + isSelected);




    }

}
