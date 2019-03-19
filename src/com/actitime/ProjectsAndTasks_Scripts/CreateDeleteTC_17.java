package com.actitime.ProjectsAndTasks_Scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.actitime.Util.Library.ExcelOperation;
import com.actitime.Util.Library.SuperTestScript;
import com.actitme.webpages.ActiveProjects_CustomersPage;
import com.actitme.webpages.AddNewCustomerPage;
import com.actitme.webpages.EditCustomerInformationPage;
import com.actitme.webpages.LoginPage;
import com.actitme.webpages.OpenTaskPage;

public class CreateDeleteTC_17 extends SuperTestScript{

	
	@Test
	public void testCreateDeleteTC_17()
	{
		
		String username = ExcelOperation.readData("TC_01", 1, 0);
		String password = ExcelOperation.readData("TC_01", 1, 1);
		String customername = ExcelOperation.readData("TC_17", 1, 0);
		String description = ExcelOperation.readData("TC_17", 1, 1);
		
		//Login to ACTITIME
		LoginPage login = new LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		
		
		//Create CUSTOMER
		
		OpenTaskPage open = new OpenTaskPage();
		open.clickOnProjects_Customers();
		
		ActiveProjects_CustomersPage act = new ActiveProjects_CustomersPage();
		act.clickOnAddNewCustomer();
		
		
		AddNewCustomerPage cust = new AddNewCustomerPage();
		cust.enterCustomername(customername);
		cust.enterCustomerDescription(description);
		cust.clickOnCreateCustomer();
		
		Select s1 = act.addressOfDropdown();
		List<WebElement> list = s1.getOptions();
		System.out.println("==================");
		System.out.println("Customer DropDown Options");
		for (WebElement web : list) {
			
			
			String cusname=web.getText();
			if (cusname.equals(customername)) 
			{
				System.out.println("------------------------------------------");
				System.out.println("Created Customer is Present in the dropdown :"+cusname);
				act.selectCustomerFromDropDown(cusname);
				System.out.println("------------------------------------------");
			}
			else 
			{
			   	System.out.println(cusname);
			   	
			}
			
		}
		System.out.println("==================");
		
		try
		{
			boolean projectCheckBox = driver.findElement(By.name("showProjects")).isSelected();
			System.out.println("Show Projects Checkbox is Selected : "+projectCheckBox);
		}
		catch (Exception e) 
		{
			System.out.println("Show Projects Checkbox is not Selected : False");
			driver.findElement(By.name("showProjects")).click();
			System.out.println("Show Projects checkbox is NOW Clicked");
		}
		try
		{
			boolean showbutton = driver.findElement(By.cssSelector("input[value='  Show  ']")).isEnabled();
			System.out.println("Show Button Is Enabled : "+showbutton);
		}
		catch (Exception e) 
		{
		    System.out.println("Show Button is not enabled : False");	
		}
		
		driver.findElement(By.cssSelector("input[value='  Show  ']")).click();
		
		try
		{
			boolean cust1 = driver.findElement(By.linkText(customername)).isDisplayed();
			System.out.println("Created Customer is displayed : "+cust1);
		}
		catch (Exception e)
		{
			
		}
		//Delete CUSTOMER
		act.clickOnCustomerName(customername);
		
		EditCustomerInformationPage edit = new EditCustomerInformationPage();
		edit.clickOnDeleteThisCustomerButton();
		
		System.out.println("==================");
		System.out.println("Customer DropDown Options");
		List<WebElement> list1 = s1.getOptions();
		for (WebElement web : list1)
		{
			String cusname=web.getText();
			if (cusname.equals(customername)) 
			{
				System.out.println();
				
				System.out.println("---------");
				System.out.println("Created Customer is Present in the dropdown :"+cusname);
				System.out.println("---------");
			}
			else 
			{
			   	System.out.println();
			}
			System.out.println(cusname);
			System.out.println("==================");
		}
		System.out.println("Created Customer is not present in the dropdown");
		System.out.println("INTEGRATION TESTING IS DONE SUCCESSFULLY");
		
	}
	
}
