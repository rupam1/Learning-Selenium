package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerSelection {
	@FindBy(xpath = "//select[contains(@name,'customerAccountType')]") WebElement Accounttype;
	
	
	public void ChkAccountTypeDropDownBtn() {
		Select dropdown = new Select(Accounttype);
		dropdown.selectByVisibleText("All");
		dropdown.selectByVisibleText("Free");
		dropdown.selectByVisibleText("Paid");
	}
	public void ChkRegularAccntIsDisplaying() {
		Select regulardrpdwn = new Select(Accounttype);
		regulardrpdwn.selectByVisibleText("Regular");
	}
	

	
}
