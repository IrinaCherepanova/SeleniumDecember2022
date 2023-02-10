package lesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.plaf.basic.BasicSliderUI;
import java.nio.file.WatchEvent;
import java.util.*;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://devexpress.github.io/testcafe/example/");

        String name = "Irina";

        WebElement nameInput = driver.findElement(By.cssSelector("[data-testid='name-input']"));
        nameInput.sendKeys(name);

        WebElement remoteTestingCheckbox = driver.findElement(By.cssSelector("[data-testid='remote-testing-checkbox']"));
        remoteTestingCheckbox.click();

        WebElement reusingJsCodeCheckbox = driver.findElement(By.cssSelector("[data-testid='reusing-js-code-checkbox']"));
        reusingJsCodeCheckbox.click();

        WebElement parallelTestingCheckbox = driver.findElement(By.cssSelector("[data-testid='parallel-testing-checkbox']"));
        parallelTestingCheckbox.click();

        WebElement ciCheckbox = driver.findElement(By.cssSelector("[data-testid='ci-checkbox']"));
        ciCheckbox.click();

        WebElement analysisChechbox = driver.findElement(By.cssSelector("[data-testid='analysis-checkbox']"));
        analysisChechbox.click();

        WebElement triedTestCafeCheckbox = driver.findElement(By.cssSelector("[data-testid='tried-testcafe-checkbox']"));
        triedTestCafeCheckbox.click();

        WebElement commentArea = driver.findElement(By.cssSelector("[data-testid='comments-area']"));
        commentArea.sendKeys("my comment");
        
        WebElement slider = driver.findElement(By.cssSelector("[id=slider]"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 30, 0).build();
        action.perform();

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid='submit-button'"));
        submitButton.click();

        WebElement thankYouHeader = driver.findElement(By.cssSelector("[data-testid='thank-you-header'"));

        if (thankYouHeader.getText().equals("Thank you, " + name + "!")){
            System.out.println("Text is correct");
        }
        else {
            System.out.println("Something wrong with text");
        }

        if(driver.getCurrentUrl().equals("https://devexpress.github.io/testcafe/example/thank-you.html")){
            System.out.println("URL is correct");
        }
        else {
            System.out.println("Something wrong with URL");
        }

        if (driver.getTitle().equals("Thank you!")){
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Something wrong with title");
        }

        Thread.sleep(3000);

        driver.quit();
    }
}
