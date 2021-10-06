package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebDriverFactory;
import testCases.AddUserTest;

public class AddUserpage {
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement EmpName;
	@FindBy(id="systemUser_userName")
	private WebElement usename;
	@FindBy(id="systemUser_password")
	private WebElement password;
	@FindBy(id="systemUser_confirmPassword")
	private WebElement repassword;
	@FindBy(id="btnSave")
	private WebElement save;
	@FindBy(id="systemUser_userType")
	private WebElement userRole;
	
	private WebDriverWait wait;
	
	public 	AddUserpage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		wait=new WebDriverWait(WebDriverFactory.getDriver(), 20);
	}
	
	public AdminPage addusermethod(String emp,String user,String pass,String repass) {
		Select userScrolDown=new Select (userRole);
		userScrolDown.selectByIndex(1);
		EmpName.sendKeys(emp);
		usename.sendKeys(user);
		password.sendKeys(pass);
		repassword.sendKeys(repass);
		save.click();
		return new AdminPage().isPageLoaded();
	}
	
	
	public AddUserpage isPageLoaded() {
		wait.until(ExpectedConditions.visibilityOf(EmpName));
		return this;
	}

}

