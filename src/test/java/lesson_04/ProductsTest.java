package lesson_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class ProductsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Thread.sleep(2000);

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.chooseProduct("Sauce Labs Backpack", "Sauce Labs Bike Light");
        productsPage.validateText(2);

        Thread.sleep(2000);

        driver.quit();

    }

}
