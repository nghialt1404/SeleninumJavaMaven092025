package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public static void createDriver(){

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Created Chorme Driver ");
    }
    public static void closeDriver(){
        if (driver !=null) {
            driver.quit();
            System.out.println("Closed Chrome Driver");

        }
    }
}
