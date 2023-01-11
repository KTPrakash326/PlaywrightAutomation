package com.ecommerce.pages;

import java.sql.SQLException;

import com.ecommerce.dbtest.Db_Test;
import com.microsoft.playwright.Page;

public class CheckoutPage extends Db_Test {

	private Page page;
	
	private String firstName = "//input[@name='billing_first_name']";
	private String lastName = "//input[@name='billing_last_name']";
	private String address = "//input[@name='billing_address_1']";
	private String city = "//input[@name='billing_city']";
	private String pinCode = "//input[@name='billing_postcode']";
	private String email = "//input[@name='billing_email']";
	private String placeOrder = "//button[@class='button alt']";
	private String confirmationMsg = "//p[text()='Thank you. Your order has been received.']";//"//p[text()='Thank you. Your order has been received.']";
	
	public CheckoutPage(Page page) {
		this.page=page;
	}                  
	
	public String getcheckoutPageUrl()
	{
		String url = page.url(); 
		return url;
		
	}
	
	public boolean placeOrder() throws SQLException, InterruptedException
	{
		String[] storage = db();
		page.fill(firstName,storage[0]);
		page.fill(lastName,storage[1]);
		page.fill(address,storage[2]);
		page.fill(city,storage[3]); 
		page.fill(pinCode,storage[4]);
		page.fill(email,storage[5]);
		page.click(placeOrder);
		page.waitForTimeout(5000);
		return page.isVisible(confirmationMsg);
		
	}

}
