package Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleBasicMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
//        driver = new EdgeDriver();
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://anhtester.com");

        driver.navigate().to("https://anhtester.com");
        Thread.sleep(1000);

        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(1000);

        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Source: " + driver.getPageSource());

        System.out.println("----------------------------");
        System.out.println(driver.getPageSource().contains(" Login | Anh Tester Blog"));;



        driver.quit();

    }
}
