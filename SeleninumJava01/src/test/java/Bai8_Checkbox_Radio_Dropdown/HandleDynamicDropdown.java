package Bai8_Checkbox_Radio_Dropdown;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class HandleDynamicDropdown extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        createDriver();
        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        Thread.sleep(2000);
        // Click Dropdown
        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']")).click();
        Thread.sleep(2000);
        // Search value
        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']/parent::a/following-sibling::div//input")).sendKeys("Travel");
        Thread.sleep(2000);
        // Click value
        driver.findElement(By.xpath("//li[@class='active-result highlighted']")).click();
        // Lấy xpath bằng cách khác
        //driver.findElement(By.xpath("//span[normalize-space()='Select a Category']/parent::a/following-sibling::div/descendant::ul//li[normalize-space()='Travel']")).click();
        Thread.sleep(2000);

        // Cách ENTER dùng cho trường hợp chỉ hiển thị 1 giá trị lựa chọn
        // Actions action = new Actions(driver);
        // action.sendKeys(Keys.ENTER).perform();
        // Thread.sleep(2000);
        closeDriver();


    }

}
