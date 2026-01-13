package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    By productsButton = By.xpath("//a[text()=' Products']");
    By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    By addToCartButton = By.xpath("(//a[text()='Add to cart'])[1]");
    By viewCartButton = By.xpath("//u[text()='View Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openProductsPage() {
        driver.findElement(productsButton).click();
    }

    public void addFirstProductToCart() {

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstProduct)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", addToCart);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addToCart);
    }


    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
    }
}
