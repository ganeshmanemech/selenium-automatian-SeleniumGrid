package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.IInvokedMethodImpl;
import pages.LoginPage;

@Listeners(IInvokedMethodImpl.class)
public class AddUserTest {
	@Test
	public void addUsercase() {
		new LoginPage()
		.loginMethod("Admin", "admin123")
		.display()
		.adminguid()
		.adduserNevigate()
		.addusermethod("Alice Duval", "manishpatil@12", "manishpatil@1234", "manishpatil@1234");
		
	}

}
