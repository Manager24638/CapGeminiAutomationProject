package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.ArchievedProjectAndCustomersPage;
import com.actitme.webpages.EditProjectInformationPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class UnArchieveProjectTC_16 extends SuperTestScript{

	
	@Test
	public void testUnArchieveProjectTC_16() throws InterruptedException
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_16", 1, 1);
    	String projectname = ExcelOperation.readData("TC_16", 1, 0);
    	String customername = ExcelOperation.readData("TC_16", 4, 0);
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	
    	
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password);
    	
    	lp.clickOnLoginButton();
    	
    	otp.clickOnArchieves();
    	
    	//Restore archieved customer
        ArchievedProjectAndCustomersPage arc = new ArchievedProjectAndCustomersPage();
        arc.selectCustomerFromDropdown(customername);
        arc.clickOnShowButton();
        arc.clickOnArchievedCustomerOrProject(projectname);
        
        EditProjectInformationPage edit = new EditProjectInformationPage();
        edit.clickOnRestoreThisProjectFromArcheive();
        
        String ActualResult =  edit.retriveSuccessMessage();
        ExcelOperation.writeData("TC_16", 1, 2, ActualResult);
        
        String status = ValidationOperation.verify(ExpectedResult, ActualResult);
        ExcelOperation.writeData("TC_16", 1, 3, status);
        
        //logout
        otp.clickOnLogoutButton();
        Thread.sleep(3000);
	
	}
}
