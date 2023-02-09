package lesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVusAppLoginWebelement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://prd.canvusapps.com/login");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("akoman@gmail.com");
        Thread.sleep(2000);
        emailInput.clear();
        Thread.sleep(2000);
        emailInput.sendKeys("akoman@sachlav.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345678");

        WebElement rememberMeCheckBox = driver.findElement(By.cssSelector("input[id='remember_me']"));
        rememberMeCheckBox.click();

        WebElement loginButton = driver.findElement(By.cssSelector("[name='button']"));
        System.out.println("loginButton.getAttribute(\"class\") = " + loginButton.getAttribute("class"));
        loginButton.click();
        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals("https://prd.canvusapps.com/sessions")){
            WebElement errorMessageElement = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice"));
            if (errorMessageElement.getText().equals("Invalid email or password")){
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
