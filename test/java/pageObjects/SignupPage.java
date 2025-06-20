package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
	}
	 
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement nameTxt;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signUpBtn;
	
	
	public void clearOldData() {
		nameTxt.clear();
		emailTxt.clear();
	}
	
	public void enterName(String name) {
		
		nameTxt.sendKeys(name);
	}
	
	public void enterMail(String mail) {
		
		emailTxt.sendKeys(mail);
	}
	
	public void clickSignUpBtn() {
		signUpBtn.click();
	}
	
	String spTitle="Automation Exercise - Signup / Login";
	
	public String getSpTitle() {
		//website always has some title
		return this.spTitle;
	}
}
