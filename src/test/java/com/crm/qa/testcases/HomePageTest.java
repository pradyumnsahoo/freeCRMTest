package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp=lp.Login(prop.getProperty("email"),prop.getProperty("password"));
	   
		
	}
	
	//test cases should be separated--independent of each other
	//before each test case--launch the browser
	//@test---execute test cases
	//after each test case --close the browser
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=hp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(hp.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		cp= hp.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
