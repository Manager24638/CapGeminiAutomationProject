package com.actitime.Users_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.AddNewUserPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;
import com.actitme.webpages.User_ListPage;

public class CreateUserTC_05 extends SuperTestScript{

	@Test
	public void testCreateUserTC_05() throws InterruptedException
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String user = ExcelOperation.readData("TC_05", 1, 0);
    	String pass = ExcelOperation.readData("TC_05", 1, 1);
    	String repass = ExcelOperation.readData("TC_05", 1, 2);
    	String firstname = ExcelOperation.readData("TC_05", 1, 3);
    	String lastname = ExcelOperation.readData("TC_05", 1, 4);
    	String ExpectedResult = ExcelOperation.readData("TC_05", 1, 5);
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password);
      	lp.clickOnLoginButton();
      	//click on users module
      	otp.clickOnUsers();
         
    	//add new user
     	User_ListPage userlist = new  User_ListPage();
      	userlist.clickOnAddNewUser();
      	
      	AddNewUserPage newuser = new AddNewUserPage();
      	newuser.enterUsername(user);
      	newuser.enterPassword(pass);
      	newuser.reenterPassword(repass);
      	newuser.enterfirstname(firstname);
      	newuser.enterlastName(lastname);
      	newuser.clickOnCreateUser();
      	
      	//retrieve success message
      	String ActualResult =userlist.retrieveSuccessMessage();
      	ExcelOperation.writeData("TC_05", 1, 6, ActualResult);
      	
      	//compare
      	
      	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
      	ExcelOperation.writeData("TC_05", 1, 7, status); 
      	
      	
      	//logout
      	otp.clickOnLogoutButton();
	}
}
