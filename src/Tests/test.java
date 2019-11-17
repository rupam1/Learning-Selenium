package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Pages.CustomerSelection;
import Pages.LoginPage;

public class test extends testbase{
	
	@Test(priority=0)
	public void EmailErrorMessageCheck() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		String errormsg = loginpage.emailerrormessage();
		Assert.assertEquals(errormsg, "Please provide your email");
	}
	
	@Test(priority=1)
	public void PasswordErrorMessageCheck() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		String passworderrmsg = loginpage.passworderrormessage();
		Assert.assertEquals(passworderrmsg, "Please provide your password");
	}
	
	@Test(priority=2)
	public void LoginTestWithInvaliadUsernamePassword () {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam1@metatude.com");
		loginpage.SetPassword("rupam1234");
		loginpage.ClickLogin();
		String b = loginpage.GetErrormsg();
		Assert.assertEquals(b, "The email or password you have entered is invalid");
		
	}
	@Test(priority=3)
	public void LoginTestWithblankUserAndPassword() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("");
		loginpage.SetPassword("");
		Assert.assertTrue(loginpage.logbuttondisabled(), "Button is disabled");
		
	}
	
	@Test(priority=4)
	public void LoginTestWithInvalidUserAndValidPassword() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam1@metatude.com");
		loginpage.SetPassword("rupam123");
		loginpage.ClickLogin();
		Assert.assertEquals(loginpage.GetErrormsg(), "The email or password you have entered is invalid");
	}
	@Test(priority=5)
	public void LoginTestwithValidUserAndInvalidPassword() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam@metatude.com");
		loginpage.SetPassword("metatude");
		loginpage.ClickLogin();
		Assert.assertEquals(loginpage.GetErrormsg(), "The email or password you have entered is invalid");
	}

	@Test(priority=6)
	public void LoginTestWithValidUserAndPassword() {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.SetEmail("rupam@metatude.com");
		loginpage.SetPassword("rupam123");
		loginpage.ClickLogin();
		Assert.assertEquals(loginpage.Chklogoutbtn(), "LOG OUT");
		
	}
	@Test(priority=7)
	public void ChkAccountType() {
		CustomerSelection customerselection = PageFactory.initElements(driver, CustomerSelection.class);
		customerselection.ChkAccountTypeDropDownBtn();
		customerselection.ChkRegularAccntIsDisplaying();
	}
	
	@Test(priority=8)
	public void Chksearchbox() {
		CustomerSelection customerselection = PageFactory.initElements(driver, CustomerSelection.class);
		customerselection.ChkSearchboxDetails();
	}
	
	@Test(priority=9)
	public void ChkRegularType() {
		CustomerSelection customerselection = PageFactory.initElements(driver, CustomerSelection.class);
		String Reg = customerselection.ChkRegularAccntIsDisplaying();
		Assert.assertEquals(Reg, "Regular");
		
	}

	//@AfterSuite
	//public void quit() {
		//driver.quit();
	//}

}
