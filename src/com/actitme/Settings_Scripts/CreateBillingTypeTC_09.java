package com.actitme.Settings_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.AddNewBillingTypesPage;
import com.actitme.webpages.BillingTypesPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreateBillingTypeTC_09 extends SuperTestScript{

	@Test
	public void testCreateBillingTypeTC_09()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_09", 1, 1);
    	String billingtypename = ExcelOperation.readData("TC_09", 1, 0);
    	
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password); 	
    	lp.clickOnLoginButton();
    	
    	//click on settings
    	otp.clickOnSettings();
    	
    	// Create Billing type
    	
    	BillingTypesPage bill = new BillingTypesPage();
    	bill.clickOnNewBillingType();
    	
    	AddNewBillingTypesPage newbill = new AddNewBillingTypesPage();
    	newbill.enterBillingTypeName(billingtypename);
    	newbill.clickOnCreateBillingType();
    	
    	String ActualResult = bill.retrieveSuccessMessage();
    	ExcelOperation.writeData("TC_09", 1, 2, ActualResult);
    	String statuss = ValidationOperation.verify(ExpectedResult, ActualResult);
    	ExcelOperation.writeData("TC_09", 1, 3, statuss);
    	
    	//logout
    	
    	otp.clickOnLogoutButton();
	}
}
