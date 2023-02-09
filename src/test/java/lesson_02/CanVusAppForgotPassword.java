package lesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVusAppForgotPassword {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://prd.canvusapps.com/password_resets/new");

        WebElement emailInput = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/input"));
        emailInput.clear();
        emailInput.sendKeys("qwerty@gmail.com");

        WebElement resetButton = driver.findElement(By.cssSelector("input[value='Reset Password']"));
        resetButton.click();

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://prd.canvusapps.com/login")){
            WebElement errorMessageElement = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice"));
            if (errorMessageElement.getText().equals("Email sent with password reset instructions.")){
                System.out.println("ALl tests are passed! :)");
            }
            else {
                System.out.println("Invalid message!");
            }
        }
        else {
            System.out.println("Invalid URL!");
        }

        Thread.sleep(3000);

        driver.quit();
    }
}
