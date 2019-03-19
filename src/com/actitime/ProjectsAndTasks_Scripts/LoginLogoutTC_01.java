package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class LoginLogoutTC_01 extends SuperTestScript {
     
	@Test
	public void testLoginLogoutTC_01() throws InterruptedException
	{
		String username = ExcelOperation.readData("TC_01", 1, 0);
		String password	= ExcelOperation.readData("TC_01", 1, 1);
		String ExpectedResult = ExcelOperation.readData("TC_01", 1, 2);
		LoginPage lp = new LoginPage();
		OpenTaskPage otp = new OpenTaskPage();
		lp.enterUsername(username);
	    lp.enterPassword(password);
		lp.clickOnLoginButton();
		String ActualResult = otp.retrieveWebPageTitle();
		ExcelOperation.writeData("TC_01", 1, 3, ActualResult);
		String status = ValidationOperation.verify(ExpectedResult, ActualResult);
		ExcelOperation.writeData("TC_01", 1, 4, status);
		otp.clickOnLogoutButton();
		Thread.sleep(3000);
		
		
	}
	
}
