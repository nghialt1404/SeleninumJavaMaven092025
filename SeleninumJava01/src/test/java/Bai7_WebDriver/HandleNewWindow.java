package Bai7_WebDriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class HandleNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();


        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.navigate().to("https://google.com");

        Thread.sleep(1000);
        driver.quit();

    }
}
