package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AddressPage extends TestBase {

	@FindBy(xpath = "//h2[contains(text(),'Addresses')]")
	WebElement addressLabel;
	
	@FindBy(id="address_first_name")
	WebElement firstName;
	
	@FindBy(id="address_last_name")
	WebElement lastName;
	
	@FindBy(id="address_street_address")
	WebElement address1;

	@FindBy(id="address_secondary_address")
	WebElement address2;
	
	@FindBy(id="address_city")
	WebElement city;
	
	@FindBy(id="address_state")
	WebElement state;

	@FindBy(css = "[value=\"Create Address\"]")
	WebElement saveBtn;
	
	@FindBy(id="address_zip_code")
	WebElement zipCode;
	
	// Initializing the Page Objects:
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyAddressLabel(){
		return addressLabel.isDisplayed();
	}
	
	
	public int getRowIndexHavingFirstName(String firstName){
		int rowIndex=-1;
		List<WebElement> totalrows= driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println("--------------------------");
		for(int i=0; i<totalrows.size();i++) {
			System.out.println(totalrows.get(i).getText());
			WebElement row=totalrows.get(i);
			if(firstName.equals(row.findElement(By.cssSelector("td:nth-child(1)")).getText())) {
				System.out.println("Text is "+row.findElement(By.cssSelector("td:nth-child(1)")).getText());
				return i;
			}
			
		}
		return rowIndex;
	}
	
	
	public void createNewAddress(String ftName, String ltName, String addss1, String addss2, String addressCity, String stateName, String zipCodeIs){
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		address1.sendKeys(addss1);
		address2.sendKeys(addss2);
		city.sendKeys(addressCity);
		Select stateselect = new Select(driver.findElement(By.id("address_state")));
		System.out.println("zipCodeIs"+zipCodeIs);
		zipCode.sendKeys(zipCodeIs);
		stateselect.selectByVisibleText(stateName);
		saveBtn.click();
		
	}
	
	
	

}
