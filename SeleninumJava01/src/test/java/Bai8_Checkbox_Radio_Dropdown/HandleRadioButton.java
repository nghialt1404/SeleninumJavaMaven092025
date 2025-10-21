package Bai8_Checkbox_Radio_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleRadioButton {

    public static void handleRadioButton1() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/radio-button");

        boolean checkRadio = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        System.out.println("Radio button 'Yes' is selected: " + checkRadio);

        // Your code to handle radio buttons goes here
        driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
        Thread.sleep(2000);

        boolean checkRadio2 = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        System.out.println("Radio button 'Yes' is selected: " + checkRadio2);

        driver.quit();
    }

    public static void HandlelistRadioButton() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[@class='menu-text' and normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Proposals']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Proposal']")).click();

        List<WebElement> listRadio = driver.findElements(By.xpath("//span[normalize-space()='Show quantity as:']/following-sibling::div/input"));
        System.out.println("Total radio buttons: " + listRadio.size());

        Thread.sleep(2000);
        int check1 = 0;
        int check2 = 0;
        for (int i = 0; i < listRadio.size(); i++) {
            if (listRadio.get(i).isSelected()) {
                System.out.println("Radio button " + (i + 1) + " is selected");
                check1++;
            } else {
                System.out.println("Radio button " + (i + 1) + " is not selected");
                check2++;
            }
        }
        System.out.println("Total selected radio buttons: " + check1);
        System.out.println("Total unSelected radio buttons: " + check2);

        //Click chọn  radio button -

        driver.findElement(By.xpath("//label[normalize-space()='Hours']")).click();
        Thread.sleep(2000);
        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        //handleRadioButton1();
        HandlelistRadioButton();
    }
}
