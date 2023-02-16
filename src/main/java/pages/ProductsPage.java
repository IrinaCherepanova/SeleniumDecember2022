package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "[class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindAll(@FindBy(css = "[class='inventory_item_description']"))
    private List<WebElement> itemDescriptionElements;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseProduct(String... products ) {
 //       List<WebElement> itemDescriptionElements = driver.findElements(By.cssSelector("[class='inventory_item_description']"));

        for (String product: products) {
            for (WebElement element : itemDescriptionElements) {
                WebElement title = element.findElement(By.cssSelector("[class='inventory_item_name']"));
                WebElement addToCartButton = element.findElement(By.cssSelector("button"));
                if (title.getText().equals(product)) {
                    addToCartButton.click();
                }
            }
        }
    }

    public void validateText(int numberOfAddedItems){
        if (Integer.parseInt(getElementText(shoppingCartBadge)) == numberOfAddedItems) {
            System.out.println("Correct!");
        }
        else{
            System.out.println("Incorrect!");
        }
    }


}
