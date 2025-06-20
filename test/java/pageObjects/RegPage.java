package pageObjects;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage extends BasePage{
	private WebDriver driver;
    public RegPage(WebDriver driver) {
		super(driver);
		
		  this.driver = driver;
	      new WebDriverWait(driver, Duration.ofSeconds(10));
	}
//registration form fields
	
	@FindBy(xpath="//input[@data-qa='name']")
	WebElement nameTxt;
	
	@FindBy(xpath="//input[@data-qa='mail']")
	WebElement mailTxt;
	
	@FindBy(xpath="//input[@data-qa='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath="//input[@data-qa='first_name']")
	WebElement fnameTxt;
	
	@FindBy(xpath="//input[@data-qa='last_name']")
	WebElement lnameTxt;
	
	@FindBy(xpath="//input[@data-qa='address']")
	WebElement addressTxt;
	
	@FindBy(xpath="//input[@data-qa='state']")
	WebElement stateTxt;
	
	@FindBy(xpath="//input[@data-qa='city']")
	WebElement cityTxt;
	
	@FindBy(xpath="//input[@data-qa='zipcode']")
	WebElement zipTxt;
	
	@FindBy(xpath="//input[@data-qa='mobile_number']")
	WebElement phoneTxt;
	
	@FindBy(xpath="//button[@data-qa='create-account'] || //button[@type='submit'] || //button[@class='btn'][@class='btn-default']")
	WebElement createAccountBtn;
	
	//messages
	
	@FindBy(xpath="//section[@id='form']/div/div/div[3]/div/form/p")
	public
	WebElement badEmailMsg;
	

	@FindBy(xpath="//h2[contains(@class,'text') or @data-qa='account-created' or @style='clolor:green;']")
	WebElement accountCreatedMsg;
	
	//webpage buttons
	@FindBy(xpath="//a[@data-qa='continue-button']")
	public
	WebElement continueBtn;
	
	//account deletion locators
	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement deleteAccountLnk;
	
	@FindBy(xpath="//section[@id='form']/div/div/div/h2/b")
	WebElement accountDeletedMsg;
	
	
	//action methods
	public String getName() {
		return (nameTxt.getText());
	}
	
	public String getMail() {
		return (mailTxt.getText());
	}
	
	public void enterPassword(String password) {
		myWait();
		passwordTxt.sendKeys(password);
	}
	
	public void enterFname(String fname) {
		myWait();
		fnameTxt.sendKeys(fname);
	}
	
	public void enterLname(String lname) {
		myWait();
		lnameTxt.sendKeys(lname);
	}
	
	public void enterAddress(String address) {
		myWait();
		addressTxt.sendKeys(address);
	}
	
	
	public void enterState(String state) {
		myWait();
		stateTxt.sendKeys(state);
	}
	
	public void enterCity(String city) {
		myWait();
		cityTxt.sendKeys(city);
	}
	
	public void enterZip(String zip) {
		myWait();
		zipTxt.sendKeys(zip);
	}
	
	public void enterPhoneNo(String phone) {
		myWait();
		phoneTxt.sendKeys(phone);
	}
	
	public void clickCreateAccountBtn() {
		//Option 1
		waitForElement(this.createAccountBtn, 10);
		createAccountBtn.click();
		
		//2
		//myWait();
		//signUpBtn.submit();
		
		//3)
		//myWait();
		//Actions act=new Actions(driver);
		//act.moveToElement(signUpBtn).click().perform();
		
		//4)
		//myWait();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",signUpBtn);
		
		//5)
		//myWait();
		//signUpBtn.sendKeys(Keys.RETURN);

		//6)
		//myWait();
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
	}
	
	public boolean isErrorMsgDisplayed() {
	    try {
	        return badEmailMsg.isDisplayed();
	    	} 
	    catch (NoSuchElementException e) {
	        // Element is not found, thus it's not visible
	        return false; // This is what we expect
	    }
	}
	
	public WebElement getAccountCreationMsg() {
		return accountCreatedMsg;
	}
	
	public String accountCreationMsg() {
		// Waits until the h2 element loads
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getAccountCreationMsg()));

	    // Find the element and get its text
	    return getAccountCreationMsg().getText();
	}       
	
		
	public String getAccountDeletedMsg() {
		return(accountDeletedMsg.getText());
	}
	
	
	public void clickDeleteAccountLnk() {
		deleteAccountLnk.click();
	}
	
	public void clickContinueBtn() {
		getContinueBtn().click();
	}

	public WebElement getContinueBtn() {
		return continueBtn;
		}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}	
}