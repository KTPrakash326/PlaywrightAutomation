package com.ecommerce.pages;

import com.microsoft.playwright.Page;

public class Homepage {
	private Page page;
	
	private String logo = "//h1/a[@rel='home']";
	private String storeBtn="a:has-text('Store')";
	
	public Homepage(Page page) {
	this.page=page;
	}
	
	public String getHomePageTitle() throws InterruptedException
	{
		String title = page.title(); 
		return title;
	}
	
	public String getHomePageUrl() throws InterruptedException
	{
		String url = page.url();
		return url;
	}
	
	
	public boolean verifyLogo() throws InterruptedException
	{
		if(page.isVisible(logo))
		{
			return true;
		}
		return false;
	}
	
	public StorePage clickStoreTab() throws InterruptedException
	{
		page.click(storeBtn);
		page.waitForTimeout(3000);
		return new StorePage(page);
		
	}
}
