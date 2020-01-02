package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Pradyumn Sahoo')]")
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(@href,'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(@href,'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		
		return userNamelabel.isDisplayed();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	
	}

}
