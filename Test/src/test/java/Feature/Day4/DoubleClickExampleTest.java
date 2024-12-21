package Feature.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DoubleClickExampleTest {

    public static void main(String[] args) throws InterruptedException {


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        //Tim
        WebElement button = driver.findElement(By.tagName("button"));

        WebElement button1 = driver.findElement(By.xpath("//span[contains(@class,'context')]"));



        Actions actions = new Actions(driver);

        //actions.doubleClick(button).perform();
        actions.contextClick(button1).perform();
        Thread.sleep(2000);

        WebElement button2= driver.findElement(By.xpath("//li[contains(@class,'edit')]"));
        button2.click();


       String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);

        driver.switchTo().alert().accept();

        Thread.sleep(3000);

        driver.quit();




    }
}
