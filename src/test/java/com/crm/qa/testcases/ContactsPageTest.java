package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp=lp.Login(prop.getProperty("email"),prop.getProperty("password"));
		cp=hp.clickOnContactsLink();
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() throws InterruptedException {
		
		Assert.assertTrue(cp.verifyContactsLabel(),"Label is other than Contacts");
		}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		cp.selectContactsByName("Pradyumn Kumar Sahoo");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		cp.selectContactsByName("Pradyumn Kumar Sahoo");
		cp.selectContactsByName("Prakash Kumar Sahoo");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname, String city) {
		hp.clickOnNewContactLink();
//		cp.createNewContact("Tom1", "Peter1", "Delhi1");
		cp.createNewContact(firstname, lastname, city);
	}
	
		
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	

}
