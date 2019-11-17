package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Tests.testbase;

public class CustomerSelection extends testbase {
	@FindBy(xpath = "//select[contains(@name,'customerAccountType')]") WebElement Accounttype;
	@FindBy(xpath = "(//span[contains(.,'Regular')])[2]") WebElement Regtype;
	@FindBy(xpath = "//input[contains(@class,'search-text-box ng-untouched ng-pristine ng-valid')]") WebElement searchbox;
	
	
	public void ChkAccountTypeDropDownBtn() {
		Select dropdown = new Select(Accounttype);
		dropdown.selectByVisibleText("All");
		dropdown.selectByVisibleText("Free");
		dropdown.selectByVisibleText("Paid");
	}
	
	public void ChkSearchboxDetails() {
		Actions act = new Actions(driver);
		act.keyDown(searchbox, Keys.SHIFT);
		act.sendKeys(searchbox, "Airbnb");
		act.keyUp(searchbox, Keys.SHIFT);
		Action a = act.build();
		a.perform();
	}
	
	public String  ChkRegularAccntIsDisplaying() {
		Select regulardrpdwn = new Select(Accounttype);
		regulardrpdwn.selectByVisibleText("Regular");
		String Regular = Regtype.getText();
		return Regular;
	}
	

	
}
