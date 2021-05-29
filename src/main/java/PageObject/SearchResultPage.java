package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    WebDriver driver;
    Header header;

    By productListSelector = By.cssSelector(".listing-product .pdt-item");
    By productListImgSelector = By.cssSelector(".listing-product .pdt-item .pic");
    By productListPriceSelector = By.cssSelector(".listing-product .pdt-item .price > .price");

    private static final int MAX_ITEM = 45;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement selectProduct(int index ) {
        if (index < 0 || index > MAX_ITEM) {
            throw new IndexOutOfBoundsException("index is incorrect");
        }

        System.out.println("Selecting element number: " + index);

        return driver.findElements(productListSelector).get(index);
    }

    public ProductPage openProduct(int index) {
        System.out.println("Opening product page");

        selectProduct(index).findElement(By.tagName("a")).click();
        return new ProductPage(driver);
    }

    public int getProductPrice(int index) {
        var product = selectProduct(index).findElement(By.cssSelector(".price > .price"));
        String mainPrice = product.getText();//+product.findElement(By.tagName("sup"));

        int price = Integer.parseInt(mainPrice.replaceAll("[^0-9]+", ""));

        System.out.println("Getting price from search result page: " + price);

        return price;
    }
}
