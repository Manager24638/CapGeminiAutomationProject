package com.actitime.Users_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.EditUserSettingsPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;
import com.actitme.webpages.User_ListPage;

public class DeleteUserTC_07 extends SuperTestScript{

	@Test
	public void testDeleteUserTC_07()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_07", 1, 0);
    	
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password);
      	lp.clickOnLoginButton();
      	
      	//click on users module
      	otp.clickOnUsers();
      	
      	User_ListPage userlist = new User_ListPage();
      	userlist.clickOnCreatedUser("Bhai, Rocky (Rocky)");
      	
      	//delete user
      	
      	EditUserSettingsPage edituser = new EditUserSettingsPage();
      	edituser.deleteCreatedUser();
      	String ActualResult = userlist.retrieveSuccessMessage();
      	ExcelOperation.writeData("TC_07", 1, 1, ActualResult);
      	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
      	ExcelOperation.writeData("TC_07", 1, 2, status);
      	
      	
	}
}
