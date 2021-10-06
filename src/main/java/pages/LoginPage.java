package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverFactory;

public class LoginPage {
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement submit;
	
	@FindBy(id="spanMessage")
	private WebElement worning;
	
	private WebDriverWait wait;
	
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		wait=new WebDriverWait(WebDriverFactory.getDriver(), 20);
	}
	
	public HomePage loginMethod(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return new HomePage().ispageLoded();
	}
	
	public LoginPage loginFailedMethod(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return this.isPageLoaded();
	}
	
	public void loginWorning(String erromsg) {
		Assert.assertEquals(worning.getText(), erromsg, "Worning msg is diffrent");
		
	}
	
	public LoginPage isPageLoaded() {
		wait.until(ExpectedConditions.visibilityOf(password));
		wait.until(ExpectedConditions.visibilityOf(username));
		return this;
	}
	

}
