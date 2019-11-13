package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath = "//input[contains(@formcontrolname,'email')]") WebElement email;
	@FindBy(xpath = "//input[contains(@id,'password')]") WebElement password;
	@FindBy(xpath = "//div[@class='btn-container'][contains(.,'Login')]") WebElement login;
	@FindBy(xpath = "//div[@class='error-msg-container'][contains(.,'The email or password you have entered is invalid')]") WebElement errormsg;
	@FindBy(xpath = "//button[@class='btn ignity-btn-sm'][contains(.,'Login')]") WebElement loginbtn;
	@FindBy(xpath = "//div[@class='navigation-item'][contains(.,'Log out')]") WebElement logoutbtn;
	@FindBy(xpath = "//span[@class='error-msg'][contains(.,'Please provide your email')]") WebElement emailerrormsg;
	@FindBy(xpath = "//span[@class='error-msg'][contains(.,'Please provide your password')]") WebElement passworderrormsg;
	
	public void SetEmail(String stremail) {
		email.clear();
		email.sendKeys(stremail);
	}
	public void SetPassword(String strpassword) {
		password.clear();
		password.sendKeys(strpassword);
	}
	public void ClickLogin() {
		login.click();
	}
	public String GetErrormsg() {
		String a = errormsg.getText();
		return a;
	}
	public Boolean logbuttondisabled() {
		Boolean lognbtn = loginbtn.isEnabled();
		return lognbtn;
	}
	public String Chklogoutbtn() {
		String logOutbtn = logoutbtn.getText();
		return logOutbtn;
	}
	public String emailerrormessage() {
		email.clear();
		email.click();
		password.clear();
		password.click();
		String errormessageemail = emailerrormsg.getText();
		return errormessageemail;
	}
	public String passworderrormessage() {
		password.clear();
		password.click();
		email.click();
		String passworderrmsg = passworderrormsg.getText();
		return passworderrmsg;
	}
}
