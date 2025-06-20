package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTest extends BaseClass {
	
	public WebDriver driver;
	
	int chosenArrayIndex = generateNumber(0, 6);
	String fname = fnames[chosenArrayIndex];  
	String lname = generateStartLetter() + generateString(4);
	String name = fname + " " + lname;
	/**
	@Test(priority = 2 )
	public void EmptyFormSubmission() {
		pis("\n	--- Testing the registration functionality... ---");
		pis("\n	--- Submitting an empty form (no name, no e-mail)... ---");
		rp.clickCreateAccountBtn();
		String lpUrl = "https://www.automationexercise.com/login"; 
		Assert.assertEquals(getCurrentPageUrl(), lpUrl);
		Assert.assertEquals(getCurrentPageTitle(), sp.getSpTitle());
		pis("\n	Finished testing the empty initial sign-up form.");		
	}
	*/
	@Test(priority = 2 )
	public void ErrorMsgNotVisible() {
			
		pis("\n	--- Testing the registration functionality... ---");
		pis("\n	Test case TC_Rg_01");
		sp.enterName(name);
	 
	    String mail = fname + "." + lname + "@mail.com";
		sp.enterMail(mail);
		sp.clickSignUpBtn();

		//checks that the error message is not displayed
		boolean isNotVisible = rp.isErrorMsgDisplayed();
	    Assert.assertFalse(isNotVisible);
	    pis("\n	Finished the test case TC_Rg_01.");
	}
	
	@Test(dependsOnMethods={"ErrorMsgNotVisible"},priority = 3 )
	public void verifyAccoutRegistration() {		    
		pis("Starting the test case TC_Rg_02...");
		rp.enterPassword("admin");
		rp.enterFname(fname);
		rp.enterLname(lname);
		
		
		int pickedArrayIndex = generateNumber(0, 2);
		String address = generateNumber(10, 99) + " " + generateStartLetter() + generateString(4) + " " + streets[pickedArrayIndex];
		rp.enterAddress(address);
		
		rp.enterState("Tester State");
		
		rp.enterCity("Pocahontas");
		
		rp.enterZip("7777777");
						
		int phoneInt = generateNumber(12576983,99986798);
		String phone = Integer.toString(phoneInt);
		rp.enterPhoneNo(phone);
		
		rp.clickCreateAccountBtn();
						
		//checks whether the confirmation message is displayed 
		
		
		String displaysConfMsg=rp.accountCreationMsg();
		String expectedMsg ="ACCOUNT CREATED!";
		pis("On creation the system collected the following message: "+ displaysConfMsg);
		Assert.assertEquals(displaysConfMsg, expectedMsg,"Account creation message does not seem to be dispalayed.");
		pis("Finished the test case TC_Rg_02.");
	}
									
	//Continue button should be displayed
	@Test(priority = 4)
	public void ContinueBtnVisible() {
		pis("\n  Starting the test case TC_Rg_03...");
		Assert.assertEquals(rp.getContinueBtn().isDisplayed(), true);
		pis("\n  Finished the test case TC_Rg_03.");
		pis("\n--- Finished testing the registration functionality.---");
	}
	
	
	
	@Test(priority = 5 )
	public void verifyDeletionMsg() {
		myWait();
		rp.clickContinueBtn();	
		pis("\n---  Starting testing the Account Deletion functionality...---");
		pis("\n  Starting the test case TC_AD_01...");
		pis("\n  Requesting account deletion.");
		rp.clickDeleteAccountLnk();
		myWait();
		String expectedMessage = "ACCOUNT DELETED!";
		Assert.assertEquals(rp.getAccountDeletedMsg(), expectedMessage);
		pis("\n  Finished the test case TC_AD_01...");
	}
	
	
	//Continue button should be displayed 
	
	@Test(priority = 6)
	public void verifyContinueBtnAgain() {
		myWait();
		pis("\n  Starting the test case TC_AD_02...");
		Assert.assertEquals(rp.getContinueBtn().isDisplayed(), true);
		rp.clickContinueBtn();
		pis("\n  Finished the test case TC_AD_02...");
		pis("\n--- Finished the testing.---");
	}

}
