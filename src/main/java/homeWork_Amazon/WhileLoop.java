package homeWork_Amazon;

import org.openqa.selenium.WebElement;

public class WhileLoop {

    MainPage mainPageAmazon;

    public WhileLoop(MainPage mainPageAmazon) {
        this.mainPageAmazon = mainPageAmazon;
    }

    public void printProducts(int pages){
        int i = 1;
        while (i <= pages){
            System.out.println("****************** page " + i + " ******************");
            for (WebElement element: mainPageAmazon.getSearchResults()) {
                if (element.getText() != "") {
                    System.out.println(element.getText());
                    System.out.println("*************************************************");
                }
            }
            mainPageAmazon.clickElement(mainPageAmazon.getNextPageButton());
            i++;
        }
    }
}
