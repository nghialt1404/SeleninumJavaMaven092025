package BT_ThucHanhCRM;

import Bai5_Locators.LocatorsCRM;
import Common.BaseTest;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddNewCustomer extends BaseTest {

    public static void LoginCRM() throws InterruptedException {

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(2000);

    }

    public static void openNewCustomerPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        Thread.sleep(2000);

    }

    public static void addNewCustomer(String customerName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(customerName);
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("14042924");
        driver.findElement(By.xpath(LocatorsCRM.inputphone)).sendKeys("0987654321");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://airfeeder.com");
        //Dropdown Group
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("My Group Testing");
        driver.findElement(By.xpath("//span[contains(normalize-space(),'My Group Testing')]")).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();

        //Dropdown Currency
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath("//a[@id='bs-select-2-1']")).click();

        //Dropdown Default Language
        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Vietnamese']")).click(); //Cách 1 dùng xpath
        //driver.findElement(By.xpath(LocatorsCRM.selectxpathLanguage("Vietnamese"))).click(); // Cách 2 gọi hàm truyền tham số language
        //driver.findElement(By.xpath(String.format(LocatorsCRM.optionLanguageDynamic,"Japanese"))).click(); // Cách 3 dùng String.format

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("123 ABC Street, New York, USA");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("New York");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("New York");
        driver.findElement(By.xpath(LocatorsCRM.inputZipcode)).sendKeys("10001");

        //Dropdown Country
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        driver.findElement(By.xpath("//span[normalize-space()='Vietnam']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();

    }

    public static void searchCustomer( String customerName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys(customerName);
        Thread.sleep(2000);

        String fristRowitemcustomer = driver.findElement(By.xpath(LocatorsCRM.fristRowItemCustomer)).getText();
        System.out.println("Frist Row Item Customer: " + fristRowitemcustomer);


    }

    public static void main(String[] args) throws InterruptedException {
        createDriver();

        LoginCRM();
        Thread.sleep(2000);

        //openNewCustomerPage();
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        int customerTotal = Integer.parseInt(driver.findElement(By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span")).getText());
        System.out.println("Customer total before adding new customer: " + customerTotal);
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        Thread.sleep(2000);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println("Thời gian định dạng: " + formattedDate);


        addNewCustomer("Airfeeder Ltd" + formattedDate);
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        int customerTotalafter = Integer.parseInt(driver.findElement(By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span")).getText());
        System.out.println("Customer total after adding new customer: " + customerTotalafter);
        if (customerTotalafter == customerTotal+1 ){
              System.out.println("Customer total is correct after adding new customer.");
         } else {
              System.out.println("Fail to add new customer.");
       }


        //searchCustomer("Airfeeder Ltd" + formattedDate);

        closeDriver();

    }
}
