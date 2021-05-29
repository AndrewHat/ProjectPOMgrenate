package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    Header header;

    By productPriceSelector = By.id("product-page-price");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getPrice() {
        String priceFromTag = driver.findElement(productPriceSelector).getAttribute("data-price");
        int price = Integer.parseInt(priceFromTag.replaceAll("[^0-9]+", ""));;

        System.out.println("Getting price from the product page: " + price);

        return  price;
    }
}
