
package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddressPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AddressPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AddressPage addressPage;
	
	String sheetName = "address";
	
	   
	public AddressPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		addressPage = new AddressPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		testUtil.switchToFrame();
		addressPage = homePage.clickOnAddressLink();
	}
	
//	@Test(priority=1)
//	public void verifyContactsPageLabel(){
//		Assert.assertTrue(addressPage.verifyAddressLabel(), "contacts label is missing on the page");
//	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		System.out.println("row is "+addressPage.getRowIndexHavingFirstName("Tom"));
		System.out.println("row is "+addressPage.getRowIndexHavingFirstName("Tom1"));
		System.out.println("row is "+addressPage.getRowIndexHavingFirstName("Tom1sdsds"));

	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest(){
//		contactsPage.selectContactsByName("test2 test2");
//		contactsPage.selectContactsByName("ui uiii");
//
//	}
//	
//	@DataProvider
//	public Object[][] getCRMTestData(){
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	
//	@Test(priority=4, dataProvider="getCRMTestData")
//	public void validateCreateNewContact(String firstName, String lastName, String address1, String address2, String city, String state, String zipCode){
//		homePage.clickOnNewAddressLink();
//		addressPage.createNewAddress(firstName, lastName, address1,address2,city,state,zipCode);
//		
//	}
//	
	

	@AfterMethod
	public void tearDown(){
//		driver.quit();
	}
	
	
	
	
}
