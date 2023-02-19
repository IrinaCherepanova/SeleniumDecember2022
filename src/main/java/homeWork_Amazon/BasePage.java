package homeWork_Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public void typeText(WebElement element, String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        System.out.println("Trying to click " + element);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("Successful " + element);
    }

    public String getElementText(WebElement element){
        return element.getText();
    }
}
