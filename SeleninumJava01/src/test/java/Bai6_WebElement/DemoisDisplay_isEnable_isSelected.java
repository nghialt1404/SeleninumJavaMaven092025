package Bai6_WebElement;

import Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoisDisplay_isEnable_isSelected {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        //Handle isDisplayed
        boolean checkHeaderLogin = driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed();
        System.out.println("Header Login is displayed: " + checkHeaderLogin);

        Thread.sleep(2000);

        //Handle isSelected
        driver.get("https://crm.anhtester.com/admin/authentication");
        boolean checkCheckboxRememberMeSelected = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("Checkbox Remember Me is selected: " + checkCheckboxRememberMeSelected);

        driver.findElement(By.xpath(LocatorsCRM.labelRememberMe)).click();
        Thread.sleep(2000);

        boolean checkCheckboxRememberMeAfterClick = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("After click - Checkbox Remember Me is selected: " + checkCheckboxRememberMeAfterClick);

        //Handle isEnabled
        driver.get("https://angular-reactive-forms-zvzqvd.stackblitz.io/");
        driver.findElement(By.xpath("//button[@onclick='__runProject()']")).click();
        Thread.sleep(2000);

        boolean checkbuttonSubmitEnable = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("Button Submit is enabled: " + checkbuttonSubmitEnable);


        driver.quit();
    }
}

