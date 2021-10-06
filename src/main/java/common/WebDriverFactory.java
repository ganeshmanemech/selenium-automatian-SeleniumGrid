package common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
//	public WebDriver chrome;
	public static ThreadLocal<WebDriver>localchrome=new ThreadLocal<>();
	
	public static void setDriver(WebDriver drive)
	{
		
		localchrome.set(drive);
	}
	
	public static WebDriver getDriver()
	{
		return localchrome.get();
	}

}
