package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.ActiveProjects_CustomersPage;
import com.actitme.webpages.EditProjectInformationPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class ArchieveProjectTC_15 extends SuperTestScript
{

	@Test
	public void testArchieveProjectTC_15()
	{

		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_15", 1, 1);
    	String projectname = ExcelOperation.readData("TC_15", 1, 0);
    	String customername = ExcelOperation.readData("TC_15", 4, 0);
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	
    	
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password);
    	
    	lp.clickOnLoginButton();
    	
    	//archieve project
    	otp.clickOnProjects_Customers();
    	
    	ActiveProjects_CustomersPage act = new ActiveProjects_CustomersPage();
    	act.selectCustomerFromDropDown(customername);
    	act.clickOnShowButton();
    	
    	act.clickOnProjectName(projectname);
        
    	EditProjectInformationPage pro = new EditProjectInformationPage();
    	pro.clickOnArchieveThisProjectButton();
    	
    	String ActualResult = act.retriveSuccessMessage();
    	ExcelOperation.writeData("TC_15", 1, 2	, ActualResult);
    	
    	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
    	ExcelOperation.writeData("TC_15", 1, 3, status);
    	
    	//logout
    	otp.clickOnLogoutButton();
	}
}
