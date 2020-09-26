package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingCart extends PageBaseStore{
    public ShoppingCart(RemoteWebDriver driver){
        super(driver);
        url="/index.php?controller=order";
    }
    private final String TITLE_PAGE_ID="cart_title";
    private final String SUMMARY_BUTTON_CSS_SELECTOR="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";
    private final String ADRESS_BUTTON_CSS_SELECTOR="#center_column > form > p > button";
    private final String SHIPPING_BUTTON_CSS_SELECTOR="#form > p > button";
    private final String SHIPPING_ACCEPT_TERM_ID="cgv";
    private final String PAYMENT_BY_BANK_WIRE_BUTTON_CSS_SELECTOR="#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String PAYMENT_BY_CHECK_BUTTON_CSS_SELECTOR="#HOOK_PAYMENT > div:nth-child(2) > div > p > a";
    private final String PAYMENT_CONFIRM_ORDER_BUTTON_CSS_SELECTOR="#cart_navigation > button";
    private final String MESSAGE_SUCCESSFUL_PURCHASE_CSS_SELECTOR="#center_column > div > strong:nth-child(10)";
    private final String USER_EMAIL_LOGIN_INPUT_ID="email";
    private final String USER_PASS_LOGIN_INPUT_ID="passwd";
    private final String SIGNIN_BUTTON_ID="SubmitLogin";


    public void verifyPage() {
        waitForElementVisibility(By.id(TITLE_PAGE_ID));
        Assert.assertTrue(isElementVisible(By.id(TITLE_PAGE_ID)));
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void clickSummaryButton(){
        waitForElementVisibility(By.cssSelector(SUMMARY_BUTTON_CSS_SELECTOR));
        clickElement(By.cssSelector(SUMMARY_BUTTON_CSS_SELECTOR));
    }
    public void clickAdressButton(){
        waitForElementVisibility(By.cssSelector(ADRESS_BUTTON_CSS_SELECTOR));
        clickElement(By.cssSelector(ADRESS_BUTTON_CSS_SELECTOR));
    }
    public void clickShippingButton(){
        waitForElementVisibility(By.cssSelector(SHIPPING_BUTTON_CSS_SELECTOR));
        driver.findElementById(SHIPPING_ACCEPT_TERM_ID).click();
        clickElement(By.cssSelector(SHIPPING_BUTTON_CSS_SELECTOR));
    }

    public void selectPaymentMethod(String metodoPago){
        if(metodoPago=="bp") {
            waitForElementVisibility(By.cssSelector(PAYMENT_BY_BANK_WIRE_BUTTON_CSS_SELECTOR));
            clickElement(By.cssSelector(PAYMENT_BY_BANK_WIRE_BUTTON_CSS_SELECTOR));
        }else {
            waitForElementVisibility(By.cssSelector(PAYMENT_BY_CHECK_BUTTON_CSS_SELECTOR));
            clickElement(By.cssSelector(PAYMENT_BY_CHECK_BUTTON_CSS_SELECTOR));
        }
        waitForElementVisibility(By.cssSelector(PAYMENT_CONFIRM_ORDER_BUTTON_CSS_SELECTOR));
        clickElement(By.cssSelector(PAYMENT_CONFIRM_ORDER_BUTTON_CSS_SELECTOR));
    }

    public void verifyOrder(){
        waitForElementVisibility(By.cssSelector(MESSAGE_SUCCESSFUL_PURCHASE_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(MESSAGE_SUCCESSFUL_PURCHASE_CSS_SELECTOR)));
    }

    public void login(String user, String pass) {
        waitForElementVisibility(By.id(USER_EMAIL_LOGIN_INPUT_ID));
        completeField(By.id(USER_EMAIL_LOGIN_INPUT_ID),user);
        completeField(By.id(USER_PASS_LOGIN_INPUT_ID), pass);
        clickElement(By.id(SIGNIN_BUTTON_ID));
    }
}
