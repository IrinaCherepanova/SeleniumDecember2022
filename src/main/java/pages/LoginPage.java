package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "[data-test='username']")
    private WebElement usernameInput;
    @FindBy(css = "[data-test='password']")
    private WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){

        typeText(usernameInput, username);
        typeText(passwordInput, password);
        clickElement(loginButton);
    }
}
