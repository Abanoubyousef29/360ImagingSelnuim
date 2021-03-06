package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTest extends TestBase {

	HomePage homeObject;
	SignInPage signInObject;
	SignUpPage signUpObject;


	//Provide Data From Excel Annotation 
	@DataProvider(name="DataSheet0")
	public Object[][] userRegisterDataSuccessfully() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();

		return ER.GetExcelDataFromSheetNumber (0);
	}



	@Test(priority=1,alwaysRun=true,dataProvider="DataSheet0")
	public void signUpSuccessfully(String FName , String LName , String Password , String FirstName , String LastName , String Address , String City , String State , String PostCode , String PhoneNumber) 
	{
		// create an object from HomePage class
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();

		// create an object from SignInPage class
		signInObject = new SignInPage(driver);
		signInObject.enterEmailInTheTxtBox();

		signInObject.clickCreateAnAccount();

		//create an object from SignUpPage class
		signUpObject = new SignUpPage(driver);
		signUpObject.userRegistration( FName , LName , Password , FirstName , LastName , Address , City ,State , PostCode , PhoneNumber );

		Assert.assertTrue(signUpObject.PageHead.getText().equalsIgnoreCase("MY AccOUNT"));
	
		signUpObject.UserCanLogOut();
	}

	
	
	
	

	//Provide Data From Excel Annotation 
	@DataProvider(name="DataSheet1")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();

		return ER.GetExcelDataFromSheetNumber (1);
	}


	//TC to confirm that sign up will fail when confirming without filling all required data
	@Test(priority=2,alwaysRun=true,dataProvider="DataSheet1")
	public void signUpFailled(String FName , String LName , String Password , String FirstName , String LastName , String Address , String City , String State , String PostCode , String PhoneNumber)
	{
		// create an object from HomePage class
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();

		// create an object from SignInPage class
		signInObject = new SignInPage(driver);
		signInObject.enterEmailInTheTxtBox();

		signInObject.clickCreateAnAccount();

		//create an object from SignUpPage class
		signUpObject = new SignUpPage(driver);
		signUpObject.userRegistration( FName , LName , Password , FirstName , LastName , Address , City , State , PostCode , PhoneNumber );

		Assert.assertTrue(signUpObject.errorMsg.getText().contains("errors"));
	}

}
