package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (className = "login")
	WebElement signInButton ;
	
	
	//Login Page Where we can sign up
	public void openLoginPage() 
	{
		clickButton(signInButton);
	}
	
	
}
