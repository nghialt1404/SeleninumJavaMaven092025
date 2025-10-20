package Bai6_WebElement;

import Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoGetText {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Thread.sleep(2000);

        String headerCustomersText = driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText();
        System.out.println("Header Customers: " + headerCustomersText);

        // So sánh
        if (headerCustomersText.equals("Customers Summary")) {
            System.out.println("Header Customers is correct");
        } else {
            System.out.println("Header Customers is incorrect");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
