package PageObject;

import PageComponent.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    Header header;

    By headerSelector = By.tagName("header");


    public HomePage(WebDriver driver) {
        this.driver = driver;

        WebElement headerContainer = driver.findElement(headerSelector);
        header = new Header(headerContainer);
    }

    public SearchResultPage search(String keyword) {
        System.out.println("Searching the item" + keyword);

        header.search(keyword);
        return new SearchResultPage(driver);
    }

}
