package lesson_03.Homework;

import homeWork_Amazon.ForLoop;
import homeWork_Amazon.MainPage;
import homeWork_Amazon.WhileLoop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Amazon {

    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        MainPage mainPageAmazon = new MainPage(driver);
        mainPageAmazon.typeText(mainPageAmazon.getSearchTextboxInput(), "tent");

        sleep(1000);
        mainPageAmazon.clickElement(mainPageAmazon.getSearchSubmitButton());
        sleep(1000);

        ForLoop forLoop = new ForLoop(mainPageAmazon);
        forLoop.printProducts(10);

        System.out.println("\n++++++++++++++++ next loop +++++++++++++++\n");

        driver.get("https://www.amazon.com/");
        mainPageAmazon.typeText(mainPageAmazon.getSearchTextboxInput(), "tent");
        mainPageAmazon.clickElement(mainPageAmazon.getSearchSubmitButton());

        WhileLoop whileLoop = new WhileLoop(mainPageAmazon);
        whileLoop.printProducts(10);

        driver.quit();
    }

     public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
