package lesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVusAppLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://prd.canvusapps.com/login");

        driver.findElement(By.id("email")).sendKeys("akoman@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("akoman@sachlav.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[id='remember_me']")).click();

        String classAttribute = driver.findElement(By.cssSelector("[name='button']")).getAttribute("class");
        System.out.println("classAttribute = " + classAttribute);
        driver.findElement(By.cssSelector("[name='button']")).click();
        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://prd.canvusapps.com/sessions")){
            String errorMessage = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice")).getText();
            if (errorMessage.equals("Invalid email or password")){
                System.out.println("ALl tests are passed! :)");
            }
            else {
                System.out.println("Invalid message!");
            }
        }
        else {
            System.out.println("Invalid URL!");
        }

        Thread.sleep(5000);

        driver.quit();

    }
}
