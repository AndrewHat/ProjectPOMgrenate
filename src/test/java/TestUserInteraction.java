import PageObject.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserInteraction {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.ldlc.com/");
        driver.manage().window().maximize();

        By cookiesSelector = By.id("cookieConsentAcceptButton");
        driver.findElement(cookiesSelector).click();
    }

    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }

    @Test
    public void productPriceTest() {
        // Arrange
        String product = "GeForce RTX 3080";
        int itemIndex = 0;
        var hp = new HomePage(driver);

        // Act

        var searchPage = hp.search(product);

        int priceSearchPage = searchPage.getProductPrice(itemIndex);
        int priceProductPage = searchPage
                .openProduct(itemIndex)
                .getPrice();

        // Assert
        Assert.assertEquals(priceProductPage, priceSearchPage, "Not the same price," +
                " product page = " + priceProductPage + " search page = " + priceSearchPage);
    }
}
