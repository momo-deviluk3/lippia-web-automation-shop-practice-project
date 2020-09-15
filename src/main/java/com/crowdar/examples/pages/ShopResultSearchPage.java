package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ShopResultSearchPage extends PageBaseStore{

    public ShopResultSearchPage(RemoteWebDriver driver) {
        super(driver);
        this.url="/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    }

    private WebElement stats() {
        return getWebElement(By.cssSelector("#center_column > ul > li> div > div.left-block > div > a.product_img_link"));
    }

    public String getStats() {
        return stats().getText();
    }




}
