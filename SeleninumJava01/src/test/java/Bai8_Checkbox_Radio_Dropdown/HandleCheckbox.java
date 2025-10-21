package Bai8_Checkbox_Radio_Dropdown;

import Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckbox {

    public static void handleCheckbox() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/checkbox");

        // Click Checkbox
        driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
        System.out.println("Checkbox Home is selected: " + driver.findElement(By.id("tree-node-home")).isSelected());
        Thread.sleep(2000);

        // UnClick Checkbox
        driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
        System.out.println("Checkbox Home is Unselected: " + driver.findElement(By.id("tree-node-home")).isSelected());
        Thread.sleep(2000);

        driver.quit();

    }

    public static void handleMultiCheckbox() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[normalize-space()='Dashboard Options']")).click();

        List<WebElement> listCheckbox = driver.findElements(By.xpath("//div[@id='dashboard-options']//input[@type='checkbox']"));
        System.out.println(listCheckbox.size());
        Thread.sleep(2000);

        boolean check = false;

        for (int i = 0; i < listCheckbox.size(); i++) {
            if (listCheckbox.get(i).isSelected()) {
                System.out.println("Checkbox " + (i+1) + " is selected.");
                check = true;
            } else {
                System.out.println("Checkbox " + (i+1) + " is not selected.");
                check = false;
                break;
//                listCheckbox.get(i).click();
//                System.out.println("Checkbox " + (i+1) + " is selected now.");
            }
        }
        System.out.println(check);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException  {
        //handleCheckbox();
        handleMultiCheckbox();
    }
}
