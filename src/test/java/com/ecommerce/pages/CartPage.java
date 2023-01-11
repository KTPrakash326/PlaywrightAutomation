package com.ecommerce.pages;

import com.microsoft.playwright.Page;

public class CartPage {

	private Page page;
	private String CouponCode = "//input[@id='coupon_code']";
	private String applyCoupon = "//button[@name='apply_coupon']";
	private String couponMsg ="//div[@class='woocommerce-message']";
	private String checkout = "//a[@class='checkout-button button alt wc-forward']";
	
	public CartPage(Page page) {
		this.page=page;
	}
	
	public String getCartPageUrl()
	{
		String url = page.url(); 
		return url;
	}
	
	public boolean applyCouponCode()
	{
		page.fill(CouponCode, "off15");
		page.click(applyCoupon);
		page.waitForTimeout(3000);
		return page.isVisible(couponMsg);
	}
	
	public CheckoutPage proceedToCheckout()
	{
		page.click(checkout);
		page.waitForTimeout(3000);
		return new CheckoutPage(page);
	}

}
