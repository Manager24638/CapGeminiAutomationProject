package com.actitime.Time_track.Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.EnterTimeTrackPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreateTimeTrackTC_12 extends SuperTestScript{

	@Test
	public void testCreateTimeTrackTC_12()
	{
		String username = ExcelOperation.readData("TC_02", 1, 0);
		String password = ExcelOperation.readData("TC_02", 1, 1);
		String customer =  ExcelOperation.readData("TC_08", 1, 0);
		String project = ExcelOperation.readData("TC_08", 1, 1);
		String ExpectedResult = ExcelOperation.readData("TC_12", 1, 1);
		String user =ExcelOperation.readData("TC_12", 1, 0);
		
		
		//login to actitime
		LoginPage login = new LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		
		//click on time track
		OpenTaskPage task = new OpenTaskPage();
		task.clickOnTimeTrack();
		
		//create timetrack
		
		EnterTimeTrackPage time = new EnterTimeTrackPage();
		time.selectUserFromTimeTrackDropdown(user);
		time.clickOnAddTaskToTheList();
		time.tranferControlToChild();
		time.selectCustomerFromDropdown(customer);
		time.selectProjectDropdown(project);
		time.clickOnShowTask();
		time.clickOnTaskCheckBox();
		time.clickOnSelectedTaskToTheList();
		time.tranferControlToMain();
		time.clickOnSaveTimeTrack();
		
		String ActualResult = time.retrieveSuccessMessage();
		ExcelOperation.writeData("TC_12", 1, 2, ActualResult);
		
		String status = ValidationOperation.verify(ExpectedResult, ActualResult);
		ExcelOperation.writeData("TC_12", 1, 3, status);
	}
}
