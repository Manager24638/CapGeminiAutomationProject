package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;
import com.actitme.webpages.ViewOpenTaskPage;

public class DeleteTaskTC_08 extends SuperTestScript{

	@Test
	public void testDeleteTaskTC_08()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
		String password = ExcelOperation.readData("TC_02", 1, 1);
		String customer =  ExcelOperation.readData("TC_08", 1, 0);
		String project = ExcelOperation.readData("TC_08", 1, 1);
		String ExpectedResult = ExcelOperation.readData("TC_08", 1, 3);
		String taskname = ExcelOperation.readData("TC_08", 1, 2);
		
		
		//login to actitime
		LoginPage login = new LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		
		//select task task
		OpenTaskPage task = new  OpenTaskPage();
		task.selectCustomerfromDropdown(customer);
		task.selectProjectfromDropdown(project);
		task.clickOnShowTasks();
		
		//delete created task
		
		task.clickOnCreatedTask(taskname);
		
		ViewOpenTaskPage view = new ViewOpenTaskPage();
		view.clickOnDeleteTask();
		
		//retrive success message
	    String ActualResult = task.retrieveTaskSuccessMessage();
	    ExcelOperation.writeData("TC_08", 1, 4, ActualResult);
	    String status = ValidationOperation.verify(ExpectedResult, ActualResult);
	    ExcelOperation.writeData("TC_08", 1, 5, status);
	    
	    //Logout
	    
	    task.clickOnLogoutButton();
	}
}
