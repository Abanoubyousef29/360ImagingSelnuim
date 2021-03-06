package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "customer_firstname")
	WebElement customerFirstNameTxtBox ;
	
	@FindBy (id = "customer_lastname")
	WebElement customerLastNameTxtBox ;
	
	@FindBy (id = "passwd")
	WebElement customerPasswordTxtBox ;
	
	
	
	@FindBy (id = "firstname")
	WebElement firstNameTxtBox ;
	
	@FindBy (id = "lastname")
	WebElement lastNameTxtBox ;
	
	@FindBy (id = "address1")
	WebElement addressTxtBox ;

	@FindBy (id = "city")
	WebElement cityTxtBox ;
	
	@FindBy (id = "id_state")
	WebElement stateDropDownMenu ;
	
	@FindBy (id = "postcode")
	WebElement postCodeTxtBox ;
	
	@FindBy (id = "phone_mobile")
	WebElement mobilePhoneTxtBox ;
	
	
	@FindBy (id = "submitAccount")
	WebElement registerButton ;
	
	@FindBy (xpath = "//h1[@class='page-heading']")
	public WebElement PageHead ;
	
	
	@FindBy (xpath = "//div[@class='alert alert-danger']")
	public WebElement errorMsg ;
	
	
	@FindBy (xpath = "//a[@class='logout']")
	WebElement logOut ;
	
	
	
	public void userRegistration(String customerFirstName , String customerLastName , String customerPassword , 
			String firstName , String lastName , String address , 
			String city, String state ,String postCode , String mobilePhone)
	{
		setTextBox(customerFirstNameTxtBox, customerFirstName);
		setTextBox(customerLastNameTxtBox, customerLastName);
		setTextBox(customerPasswordTxtBox, customerPassword);
		
		clearTextBox(firstNameTxtBox);
		setTextBox(firstNameTxtBox, firstName);
		clearTextBox(lastNameTxtBox);
		setTextBox(lastNameTxtBox, lastName);
		setTextBox(addressTxtBox, address);
		setTextBox(cityTxtBox, city);
		
		selectFromDropDownMenu(stateDropDownMenu, state);
		
		setTextBox(postCodeTxtBox, postCode);
		setTextBox(mobilePhoneTxtBox, mobilePhone);
		
		clickButton(registerButton);
		
	}
	
	public void UserCanLogOut() {
		clickButton(logOut);
	}
	

}
