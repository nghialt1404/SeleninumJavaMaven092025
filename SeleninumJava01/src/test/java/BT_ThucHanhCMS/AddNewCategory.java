package BT_ThucHanhCMS;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddNewCategory extends BaseTest {

    public static void LoginCMS() throws InterruptedException {

        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

    }
    public static void openNewCategoryPage() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@id='main-menu']/descendant::li//a[normalize-space()='Products']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://cms.anhtester.com/admin/categories']")).click();
        driver.findElement(By.xpath("//a[@href='https://cms.anhtester.com/admin/categories/create']")).click();

        Thread.sleep(2000);
    }
    public static void addNewCategory() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(" Bánh trung thu đậu xanh");
        driver.findElement(By.xpath("//button[@title='No Parent']")).click();
        driver.findElement(By.xpath("//button[@title='No Parent']/following-sibling::div//input")).sendKeys("Cake");
        driver.findElement(By.xpath("//button[@title='No Parent']/following-sibling::div//span[normalize-space()='Cake']")).click();

        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("140494");
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-2-0']")).click();

        driver.findElement(By.xpath("(//div[@data-toggle='aizuploader'])[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("lam-banh-trung-thu");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='//cms.anhtester.com/public/uploads/all/PFX3HIqoYCcgAsI6SW1lQnhsWJXes9Vix19mAa7q.webp']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys(" Bánh trung thu đậu xanh ngon vãi");

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys(" nguyên liệu ngon, chuẩn vệ sinh");
        driver.findElement(By.xpath("//button[@title='Nothing selected']")).click();
        driver.findElement(By.xpath("//button[@title='Nothing selected']/following-sibling::div//input")).sendKeys("Size");
        driver.findElement(By.xpath("//a[@id='bs-select-3-0']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

    }


    public static void main(String[] args) throws InterruptedException {
        createDriver();

        LoginCMS();

        openNewCategoryPage();

        addNewCategory();
        Thread.sleep(2000);

        // Check Category vừa Add

        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Bánh trung thu đậu xanh", Keys.ENTER);
        Thread.sleep(3000);
        String item = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Frist Item: " + item);


        closeDriver();

    }
}
