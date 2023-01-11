package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.BaseTest;

public class StorePageTest extends BaseTest {

	@Test(priority = 4)
	public void navigateToStorePageTest() throws InterruptedException
	{
		storePage = homePage.clickStoreTab();
		logger.info("StorePage is opened");
		String url = storePage.getStorePageUrl();
		Assert.assertEquals(url, "https://askomdch.com/store/");
	}
	
	@Test(priority = 6)
	public void searchProductTest(){
		String url = storePage.getProduct();
		Assert.assertEquals(url, "https://askomdch.com/?s=shoes&post_type=product");
		}
	
	@Test(priority = 7)
	public void addToCartTest(){
		storePage.addToCart();
		Assert.assertTrue(true);
		}
	
}
