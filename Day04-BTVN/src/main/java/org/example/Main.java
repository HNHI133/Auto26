package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // 1. Mở trang web mua hàng
            driver.get("https://www.saucedemo.com/");

            // 2. Đăng nhập
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);

            // 3. Thêm 3 sản phẩm vào giỏ hàng
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Thread.sleep(3000);

            // 4. Mở giỏ hàng
            driver.findElement(By.className("shopping_cart_link")).click();
            Thread.sleep(3000);

            // 5. Bắt đầu Checkout
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(3000);

            // 6. Điền thông tin thanh toán
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();
            Thread.sleep(3000);

            // 7. Xác nhận thanh toán
            driver.findElement(By.id("finish")).click();
            Thread.sleep(3000);

            // 8. Kiểm tra checkout thành công
            WebElement successMessage = driver.findElement(By.className("complete-header"));
            if (successMessage.getText().equals("Thank you for your order!")) {
                System.out.println("Checkout 3 sản phẩm thành công!");
            } else {
                System.out.println("Checkout thất bại!");
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
