package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopResultSearchPage extends PageBaseStore{


    private final String ITEM_CSS_SELECTOR="#center_column > ul > li:nth-child(1) > div";
    private final String BUTTON_MORE_ITEM_CSS_SELECTOR="#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default";




    public ShopResultSearchPage(RemoteWebDriver driver) {
        super(driver);
        this.url="/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    }

    public void verifyProduct(){
        Assert.assertTrue(isElementVisible(By.cssSelector(ITEM_CSS_SELECTOR)));
    }

    public void go(){
        navigateToCompleteURL();
    }

    public void selectItem(int item){
        clickElement(By.cssSelector(ITEM_CSS_SELECTOR));
        driver.findElementByCssSelector(BUTTON_MORE_ITEM_CSS_SELECTOR).click();
    }
}
