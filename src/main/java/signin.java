import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class signin {
    ChromeDriver driver;
    @BeforeMethod
    public void seuUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void run() {
        driver.get("https://accounts.saucelabs.com/am/XUI/#login/");
        driver.quit();

    }
}
