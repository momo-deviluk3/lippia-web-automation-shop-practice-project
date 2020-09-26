package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Product extends PageBaseStore{
    public Product(RemoteWebDriver driver) {
        super(driver);
        this.url = "/index.php?id_product=7&controller=product&search_query=dresses&results=7";
    }

    private final String NAME_PRODUCT_SELECTED_CSS_SELECTOR="#center_column > div > div > div > h1";
    private final String CANTIDAD_PRODUCTS_ID="quantity_wanted";
    private final String TALLE_ID="group_1";
    private final String ADD_TO_CART_CSS_SELECTOR="#add_to_cart > button";
    private final String CONFIRM_PURCHASE_BUTTON_CSS_SELECTOR="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a";

    public void verifyProduct(){
        //waitVisibility(NAME_PRODUCT_SELECTED_CSS_SELECTOR);
        waitForElementVisibility(By.cssSelector(NAME_PRODUCT_SELECTED_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(NAME_PRODUCT_SELECTED_CSS_SELECTOR)));
    }
    public void go(){
        navigateToCompleteURL();
    }

    public void completeCantidad(String cantidad){
        completeField(By.id(CANTIDAD_PRODUCTS_ID),cantidad);
        clickElement(By.cssSelector("#center_column > div > div > div.container"));

    }

    public void selectTalle(String talle){

        Select dropdownTalle= new Select(driver.findElementById(TALLE_ID));
        switch (talle){
            case "S":
                dropdownTalle.selectByVisibleText("S");
                break;
            case "M":
                dropdownTalle.selectByVisibleText("M");
                break;
            case "L":
                dropdownTalle.selectByVisibleText("L");
                break;
        }

    }

    public void selectColor(String color){
        if(color=="Green") {
            clickElement(By.id("color_15"));
        }else {
            clickElement(By.id("color_16"));
        }
    }

    public void addToCart(){
        clickElement(By.cssSelector(ADD_TO_CART_CSS_SELECTOR));
        waitForElementVisibility(By.cssSelector(CONFIRM_PURCHASE_BUTTON_CSS_SELECTOR));
        clickElement(By.cssSelector(CONFIRM_PURCHASE_BUTTON_CSS_SELECTOR));
    }


}
