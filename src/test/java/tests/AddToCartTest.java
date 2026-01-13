package tests;

import base.BaseTest;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCartFunctionality() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openProductsPage();
        productsPage.addFirstProductToCart();
        productsPage.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
    }
}
