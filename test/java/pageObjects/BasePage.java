package pageObjects;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
	 this.driver = driver;	
	 PageFactory.initElements(driver, this);
	}
	
	public void myWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElement(WebElement element, int time) {
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(time)); // declaration
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.getText())));	
	}
	
	public void pis(String text) {
		System.out.println(text);
	}
}
