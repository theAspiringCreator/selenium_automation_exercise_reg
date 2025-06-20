package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//p[contains(text(), 'Súhlas')]")
	WebElement suhlasBtn;
	
	@FindBy(xpath="//a[contains(text(),'Signup / Login']")
	WebElement signUpLnk;
	
	
	public WebElement getSuhlasBtn() {
	return suhlasBtn;	
	}
	
	public void clickLoginPage() {
		try 
		{
		signUpLnk.click();
		}
		catch(Exception e)
		{
		driver.get("https://www.automationexercise.com/login");	
		}
	}
	
	
}