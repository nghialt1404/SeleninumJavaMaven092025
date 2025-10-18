package Bai5_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        //Cách 1:
        // driver.findElement(By.name("password")).sendKeys("123456");
        //Cách 2:
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("123456");

        //driver.findElement(By.linkText("Forgot Password?")).click();

        //driver.findElement(By.partialLinkText("Password?")).click();


        driver.findElement(By.tagName("button")).click();  // Cách này ít dùng
        driver.findElement(By.className("btn-primary")).click(); // Cách này ít dùng


        Thread.sleep(2000);
        driver.quit();

    }
}
