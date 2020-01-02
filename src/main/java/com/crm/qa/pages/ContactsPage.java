package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[contains(@class,'ui header')]")
	WebElement contactslabel;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	

	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		
		return contactslabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::td[@class='']//preceding-sibling::td[@class='']//input[@name='id']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	
	public void createNewContact(String fname,String lname,String citi) {
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		city.sendKeys(citi);
		saveBtn.click();
	}
	
}
