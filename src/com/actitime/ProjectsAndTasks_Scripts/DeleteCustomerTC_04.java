package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.ActiveProjects_CustomersPage;
import com.actitme.webpages.EditCustomerInformationPage;
import com.actitme.webpages.EditProjectInformationPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class DeleteCustomerTC_04 extends SuperTestScript {

	@Test
	public void testDeleteCustomerTC_04()
	{
	String username = ExcelOperation.readData("TC_02", 1, 0);
	String password = ExcelOperation.readData("TC_02", 1, 1);
	String customername= ExcelOperation.readData("TC_03", 1, 0);
	String projectname = ExcelOperation.readData("TC_03", 1, 1);
	String ProjectExpectedResult = ExcelOperation.readData("TC_04", 1, 0);
	String CustomerExpectedResult = ExcelOperation.readData("TC_04", 4	, 0);
	//login to actitime
	LoginPage login = new LoginPage();
	login.enterUsername(username);
	login.enterPassword(password);
	login.clickOnLoginButton();
	//click on projects and customers
	
	OpenTaskPage open = new OpenTaskPage();
	open.clickOnProjects_Customers();
	//selet customer from drop down
	
	ActiveProjects_CustomersPage proj =new ActiveProjects_CustomersPage();
	proj.selectCustomerFromDropDown(customername);
	proj.clickOnShowButton();
	proj.clickOnProjectName(projectname);
	
	//delete project
	EditProjectInformationPage editpro = new EditProjectInformationPage();
	editpro.clickOnDeleteThisProjectButton();
	
	//retrieve success msg
	
	 String ProjectActualResult = proj.retriveSuccessMessage();
	 ExcelOperation.writeData("TC_04", 1, 1, ProjectActualResult);
	 String ProjectStatus = ValidationOperation.verify(ProjectExpectedResult, ProjectActualResult);
	 ExcelOperation.writeData("TC_04", 1, 2, ProjectStatus);
	 
		proj.selectCustomerFromDropDown(customername);
		proj.clickOnShowButton();
		proj.clickOnCustomerName(customername);
		
		//delete customer
		EditCustomerInformationPage editcus = new EditCustomerInformationPage();
		editcus.clickOnDeleteThisCustomerButton();
		
		//retrieve successmessage
		
		String CustomerActualResult = proj.retriveSuccessMessage();
		ExcelOperation.writeData("TC_04", 4, 1, CustomerActualResult);
		String CustomerStatus = ValidationOperation.verify(CustomerExpectedResult, CustomerActualResult);
		ExcelOperation.writeData("TC_04", 4, 2, CustomerStatus);
		
		//logout
		open.clickOnLogoutButton();
	}
}
