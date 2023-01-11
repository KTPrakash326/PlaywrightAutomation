package com.ecommerce.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.factory.PlaywrightFactory;
import com.ecommerce.utilities.ReadConfig;
import com.microsoft.playwright.Page;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Homepage homePage;
	protected StorePage storePage;
	protected CartPage cartPage;
	protected CheckoutPage checkoutPage;
	public Logger logger;
	
	ReadConfig readConfig = new ReadConfig();
	
	@Parameters({"browserType" })
	@BeforeClass
	public void setup(String browserType) 
	{
		logger = Logger.getLogger("E-Commerce Application");
		PropertyConfigurator.configure("log4j.properties"); 
		pf=new PlaywrightFactory();
		page = pf.initBrowser(readConfig.getAppUrl(), browserType);
		page.waitForTimeout(3000);
		homePage=new Homepage(page);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		page.context().close();
	}
}
