package homeWork_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextboxInput;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitButton;

    @FindBy(css = "[class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    private WebElement NextPageButton;

    public WebElement getSearchTextboxInput() {
        return searchTextboxInput;
    }

    public void setSearchTextboxInput(WebElement searchTextboxInput) {
        this.searchTextboxInput = searchTextboxInput;
    }

    public WebElement getSearchSubmitButton() {
        return searchSubmitButton;
    }

    public void setSearchSubmitButton(WebElement searchSubmitButton) {
        this.searchSubmitButton = searchSubmitButton;
    }

    public WebElement getNextPageButton() {
        return NextPageButton;
    }

    public void setNextPageButton(WebElement nextPageButton) {
        NextPageButton = nextPageButton;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<WebElement> searchResults) {
        this.searchResults = searchResults;
    }

    @FindAll(@FindBy(css = "[data-component-type='s-search-results'] h2>a>span "))
    private List<WebElement> searchResults;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
