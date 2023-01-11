 package com.ecommerce.factory;

import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	static Page page;
	Properties prop;
	
	
	public Page initBrowser(String appURL, String browserType)
	{
		System.out.println("Browser Name is: " +browserType);
		
		playwright=Playwright.create();
		
		switch (browserType.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser =playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser =playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			break;
		default:
			System.out.println("pass the right browser name");
	
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(appURL);
		
		return page;
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		
		page.screenshot(new Page.ScreenshotOptions()
				  .setPath(Paths.get(path))
				  .setFullPage(true));
		return path;
	}

	
}
