package Bai7_WebDriver;

import Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class HandleListElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
//        driver = new EdgeDriver();
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        // Get All Element Menu
        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@id='side-menu']/li[contains(@class,'menu-item')]"));

        for ( int i = 0;i<listMenu.size();i++) {
            String menuText = listMenu.get(i).getText();
            System.out.println("Menu " + i + ": " + menuText);
        }

        System.out.println(listMenu.get(0).getText().equals("Home"));
        System.out.println(listMenu.get(1).getText().equals("Customers"));


        Thread.sleep(2000);
        driver.quit();

    }
}
