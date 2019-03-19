package com.actitime.ProjectsAndTasks_Scripts;

import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitime.Util.Library.ValidationOperation;
import com.actitme.webpages.ActiveProjects_CustomersPage;
import com.actitme.webpages.ActiveProjects_TasksPage;
import com.actitme.webpages.AddNewCustomerPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreateCustomerTC_02 extends SuperTestScript {
	
	
    @Test
    public void testCreateCustomerTC_02() throws InterruptedException
    {
    	String username = ExcelOperation.readData("TC_02", 1, 0);
    	String password = ExcelOperation.readData("TC_02", 1, 1);
    	String ExpectedResult = ExcelOperation.readData("TC_02", 1, 1);
    	String customername = ExcelOperation.readData("TC_02", 1, 2);
    	String customerdescription = ExcelOperation.readData("TC_02", 1, 3);
    	//PAGE OBJECT MODEL
    	OpenTaskPage otp = new OpenTaskPage();
    	LoginPage lp = new LoginPage();
    	ActiveProjects_CustomersPage apc = new ActiveProjects_CustomersPage();
    	AddNewCustomerPage anc = new AddNewCustomerPage();
    	ActiveProjects_TasksPage apt = new ActiveProjects_TasksPage();
    	//LOGIN
    	lp.enterUsername(username);
    	lp.enterPassword(password);
    	
    	lp.clickOnLoginButton();
    	
    	otp.clickOnProjects_Customers();
    	
    	apc.clickOnAddNewCustomer();
    	
    	anc.enterCustomername(customername);
    	anc.enterCustomerDescription(customerdescription);
    	anc.clickOnCreateCustomer();
    	
    	String ActualResult =apt.retriveSuccessMessage();
    	ExcelOperation.writeData("TC_02", 1, 5, ActualResult);
    	String status = ValidationOperation.verify(ExpectedResult, ActualResult);
    	ExcelOperation.writeData("TC_02", 1, 6, status);;
    	apt.clickOnLogoutButton();
    	Thread.sleep(3000);
    }
}
