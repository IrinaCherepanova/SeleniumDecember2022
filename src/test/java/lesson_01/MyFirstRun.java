package lesson_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRun {

    public static void main(String[] args) throws InterruptedException {

        // Setup chromedriver
        WebDriverManager.chromedriver().setup();

        // Initialization of ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        // Current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //System.out.println("driver.getPageSource() = " + driver.getPageSource());

        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.navigate().to("https://www.yandex.ru");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        Thread.sleep(3000);

        driver.quit();

    }
}
