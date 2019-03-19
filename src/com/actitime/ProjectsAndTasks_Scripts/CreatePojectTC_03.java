package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.ActiveProjects_CustomersPage;
import com.actitme.webpages.AddNewProjectPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreatePojectTC_03 extends SuperTestScript {

	  @Test
	  public void testCreatePojectTC_03()
	  {
		  String username = ExcelOperation.readData("TC_02", 1, 0);
	    	String password = ExcelOperation.readData("TC_02", 1, 1);
	    	String customername= ExcelOperation.readData("TC_03", 1, 0);
	    	String projectname = ExcelOperation.readData("TC_03", 1, 1);
	    	String ExpectedResult = ExcelOperation.readData("TC_03", 1, 2);
	    	//login to actitime
	    	LoginPage login = new LoginPage();
	    	login.enterUsername(username);
	    	login.enterPassword(password);
	    	login.clickOnLoginButton();
	    	//click on projects and customers
	    	
	    	OpenTaskPage open = new OpenTaskPage();
	    	open.clickOnProjects_Customers();
	    	
	    	//click on add new project
	    	
	    	ActiveProjects_CustomersPage proj = new ActiveProjects_CustomersPage();
	    	proj.clickOnAddNewProject();
	    	
	    	//create project
	    	AddNewProjectPage newpro = new AddNewProjectPage();
	    	newpro.selectCustomerFromDropDown(customername);
	    	newpro.enterProjectName(projectname);
	    	newpro.clickOnCreateProject();
	    	
	        //retrive successmessage
	    	
	    	String ActualResult = proj.retriveSuccessMessage();
	    	ExcelOperation.writeData("TC_03", 1, 3	, ActualResult);
	    	
	    	//logout
	    	open.clickOnLogoutButton();
	    	
	    	//validate
	    	
	    	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
	    	ExcelOperation.writeData("TC_03", 1, 4, status);
	    	
	    	
	  }
}
