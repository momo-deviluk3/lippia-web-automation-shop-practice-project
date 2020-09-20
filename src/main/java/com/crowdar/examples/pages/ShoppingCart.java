package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShoppingCart extends PageBaseStore{
    public ShoppingCart(RemoteWebDriver driver){
        super(driver);
        url="/index.php?controller=order";
    }
    private final String TITLE_PAGE_ID="cart_title";
    private final String SUMMARY_BUTTON_CSS_SELECTOR="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";

    public void verifyPage() {
        waitForElementVisibility(By.id(TITLE_PAGE_ID));
        Assert.assertTrue(isElementVisible(By.id(TITLE_PAGE_ID)));
    }

    public void go() {
        navigateToCompleteURL();
    }
}
