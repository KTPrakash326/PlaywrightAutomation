package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getAppUrl()
	{
		return pro.getProperty("appURL");
	}
	
	public String getDbUrl()
	{
		return pro.getProperty("dbURL");
	}
	
	public String getDbUn()
	{
		return pro.getProperty("dbUN");
	}
	
	public String getDbPwd()
	{
		return pro.getProperty("dbPWD");
	}
	
}
