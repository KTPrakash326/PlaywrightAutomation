package com.ecommerce.pages;

import com.microsoft.playwright.Page;

public class StorePage {

	private Page page;
	
	private String searchProduct = "//input[@type='search']";
	private String clickSearch ="//button[@value='Search']";
	private String addToCart = "//a[@aria-label='Add “Blue Shoes” to your cart']";
	private String viewCart = "(//a[text()='View cart'])[3]";
	
	public StorePage(Page page) {
		this.page=page;
	}
	
	public String getStorePageUrl()
	{
		String url = page.url(); 
		return url;
		
	}
	
	public String getProduct()
	{
		page.fill(searchProduct, "shoes");
		page.waitForTimeout(3000);
		page.click(clickSearch);
		page.waitForTimeout(3000);
		return page.url();
	}
	
	public boolean addToCart()
	{      
		page.click(addToCart);
		page.waitForTimeout(3000);
		return page.isVisible(viewCart);	
	}
	
	public CartPage clickViewCart()
	{
		page.click(viewCart);
		page.waitForTimeout(3000);
		return new CartPage(page);
	}
}
