package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopResultSearchPage extends PageBaseStore{

    private final String ITEM_CSS_SELECTOR="#center_column > ul > li> div > div.left-block > div > a.product_img_link";

    public ShopResultSearchPage(RemoteWebDriver driver) {
        super(driver);
        this.url="/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    }

    public void verifYProduct(){
        waitForElementVisibility(By.cssSelector(ITEM_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(ITEM_CSS_SELECTOR)));
    }

    public void go(){
        navigateToCompleteURL();
    }

    public void selectItem(int item){
        clickElement(By.cssSelector("#center_column > ul > li:nth-child("+item+") > div > div.left-block > div > a.product_img_link"));
    }
}
