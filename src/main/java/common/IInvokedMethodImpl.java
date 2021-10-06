package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethodImpl implements IInvokedMethodListener {
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		WebDriverFactory.localchrome.get().quit();

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//		System.setProperty("webdriver.chrome.driver", "C:\\seleniumJava\\chromedriver.exe");
//		WebDriverFactory.setDriver(new ChromeDriver());
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("Chrome");
		cap.setVersion("94");
			
		try {
			WebDriver dr=new RemoteWebDriver(new URL("http://192.168.0.102:4441/wd/hub"),cap);
			WebDriverFactory.setDriver(dr);
			WebDriverFactory.getDriver().manage().window().maximize();
			WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	}
	
	
	

}
