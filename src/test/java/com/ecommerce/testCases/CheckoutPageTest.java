package com.ecommerce.testCases;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.BaseTest;

public class CheckoutPageTest extends BaseTest{

	@Test(priority = 10)
	public void proceedToCheckout() throws InterruptedException {
		storePage=homePage.clickStoreTab();
		storePage.addToCart();
		cartPage = storePage.clickViewCart();
		checkoutPage = cartPage.proceedToCheckout();
		logger.info("checkoutPage is opened");
		String title = checkoutPage.getcheckoutPageUrl();
		Assert.assertEquals(title, "https://askomdch.com/checkout/");
		}
	
	@Test(priority = 11)
	public void checkoutPageplaceOrderTest() throws InterruptedException, SQLException {
		boolean msg = checkoutPage.placeOrder();
		Assert.assertTrue(msg);
		}
}
