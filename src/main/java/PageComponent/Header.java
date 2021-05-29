package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Header {
    WebElement container;

    By searchBar = By.id("header");
    By searchBarSelector = By.id("search_search_text");

    public Header(WebElement container) {
        this.container = container;
    }

    public void search(String keyword) {
        container.findElement(searchBarSelector).clear();
        container.findElement(searchBarSelector).sendKeys(keyword + Keys.ENTER);
    }
}
