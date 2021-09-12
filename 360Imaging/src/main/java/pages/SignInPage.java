package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "email_create")
	WebElement emailTxtBox ;
	
	
	@FindBy (id = "SubmitCreate")
	WebElement createButton ;
	
	public void enterEmailInTheTxtBox() 
	{
		setTextBox(emailTxtBox, "Abanoub" + generateRandomString() + "@gmail.com" );
	}
	
	
	public void clickCreateAnAccount() 
	{
		clickButton(createButton);
	}
	
	
}
