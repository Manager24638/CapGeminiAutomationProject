package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.AddNewTasksPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreateTaskTC_06 extends SuperTestScript{

	@Test
	public void testCreateTaskTC_06()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_06", 1, 3);
    	String customername = ExcelOperation.readData("TC_06", 1, 0);
    	String projectname = ExcelOperation.readData("TC_06", 1, 1);
    	String taskname = ExcelOperation.readData("TC_06", 1, 2);
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password); 	
    	lp.clickOnLoginButton();
    	
    	//create task
    	
    	otp.clickOnAddNewTask();
    	
    	AddNewTasksPage newtask = new AddNewTasksPage();
    	newtask.selectCustomerFromDropdown(customername);
    	newtask.selectProjectFromDropdown(projectname);
    	newtask.enterTaskName(taskname);
    	newtask.selectbillFromDropdown(1);
    	newtask.clickOnCreateTask();
    	
    	//retrive sucess message
    	
    	String ActualResult = otp.retrieveTaskSuccessMessage();
    	ExcelOperation.writeData("TC_06", 1, 4, ActualResult);
    	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
    	ExcelOperation.writeData("TC_06", 1, 5, status);
    	
    	//logout
    	
    	otp.clickOnLogoutButton();
	}
}
