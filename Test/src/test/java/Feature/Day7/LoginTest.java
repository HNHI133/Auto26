package Feature.Day7;

//import com.sun.tools.javac.util.Assert;
import UI.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import untils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginTest {
    public LoginPageUI loginPageUI;
    String excelFilePath = "dataLogin.xlsx";


        WebDriver driver;
        WebDriverWait wait;

        @BeforeTest
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("https://saucedemo.com");
        }

        @BeforeMethod
        public void setUrl() {
            driver.get("https://saucedemo.com");
            loginPageUI = new LoginPageUI(driver);


        }
        public void inputData(String username, String password) {
            loginPageUI.inputUserName().sendKeys(username);
            loginPageUI.inputPassword().sendKeys(password);
        }
        public void clickLogin() {
            loginPageUI.buttonLogin().click();

        }
        public void loginSuccessful() {
            List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
            for(Map<String, String> map : excelData) {
                driver.get("https://saucedemo.com");
                inputData(map.get("username"), map.get("password"));
                clickLogin();
                break;
            }

        }

        public void loginFailed() {
            int count = 0;
            List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
            for(Map<String, String> map : excelData) {
                if(count > 0){
                    driver.get("https://saucedemo.com");
                    inputData(map.get("username"), map.get("password"));
                    clickLogin();
                }
                count++;
            }
            WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
            Assert.assertTrue(error.isDisplayed());


        }
        @Test
        public void inputValidUsernameAndPassword() {
            inputData("standard_user", "secret_sauce");
            clickLogin();
        }


        @Test
        public void logIn() {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("standard_user");
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("secret_sauce");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }
        @Test
        public void logInWithValidCredentials() {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("linhdt@gmail.com");
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("12345678a");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            Assert.assertEquals(driver.getTitle(), "Welcome to Homepage");

        }
        @Test
        public void logInWithInvalidPassword() {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("linhdt@gmail.com");
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("12345678b");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
//            WebElement errorMessage = driver.findElement(By.id("error-message"));
//            Assert.assertEquals(errorMessage.getText(), "Wrong password");
        }

        @Test
        public void logInWithInvalidUsername() {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("linhdt1@gmail.com");
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("12345678a");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
//            WebElement errorMessage = driver.findElement(By.id("error-message"));
//            Assert.assertEquals(errorMessage.getText(), "Wrong user name");
    }

    // Test Case 4: Input invalid username and password
    @Test
    public void logInWithInvalidCredentials() {
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("linhdt1@gmail.com");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("12345678b");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
//        Assert.assertEquals(errorMessage.getText(), "Wrong password");

//        Assert.assertEquals(errorMessage.getText(), "Wrong user name and password");
    }




        @AfterTest
        public void tearDown() {
            driver.quit();
        }

    }


