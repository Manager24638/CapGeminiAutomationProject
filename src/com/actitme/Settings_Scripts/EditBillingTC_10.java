package com.actitme.Settings_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.BillingTypesPage;
import com.actitme.webpages.EditBillingTypePage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class EditBillingTC_10 extends SuperTestScript{

	
	@Test
	public void testEditBillingTC_10()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_10", 1, 1);
    	String billingtypename = ExcelOperation.readData("TC_09", 1, 0);
    	String newbillingname = ExcelOperation.readData("TC_10", 1, 0);
    	
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password); 	
    	lp.clickOnLoginButton();
    	
    	//click on settings
    	otp.clickOnSettings();
    	
    	//modify billing type
    	BillingTypesPage bill = new BillingTypesPage();
    	bill.clickOnCreatedBilling(billingtypename);
    	
    	EditBillingTypePage edit = new EditBillingTypePage();
    	edit.enterBillingTypeName(newbillingname);
    	edit.clickOnSaveChanges();
    	
    	//compare
    	
    	String ActualResult = bill.retrieveSuccessMessage();
    	ExcelOperation.writeData("TC_10", 1, 2, ActualResult);
    	
    	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
    	ExcelOperation.writeData("TC_10", 1, 3, status);
    	
    	//logout
    	
    	otp.clickOnLogoutButton();
    	
	}
}
