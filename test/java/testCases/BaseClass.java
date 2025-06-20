package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.HomePage;
import pageObjects.RegPage;
import pageObjects.SignupPage;

public class BaseClass {
    
    public WebDriver driver;
    public HomePage hp;
    public SignupPage sp;
    public RegPage rp;
    public Properties p;

    @BeforeClass
    public void setup() throws FileNotFoundException, IOException {
        // Load configuration properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        
        // Initialize ChromeDriver with options before creating Page Objects
        ChromeOptions opt = new ChromeOptions();
        // Load your extension here (if needed)
        opt.addExtensions(new File("./extensions/AdblockUnlimited.crx"));
        // Initialize WebDriver
        driver = new ChromeDriver(opt);
        
        // Set implicit wait
        myWait();
        
        // Initialize page objects now that the driver is instantiated
        hp = new HomePage(driver);
        rp = new RegPage(driver);
        sp = new SignupPage(driver);
        
        // Perform actions on the web application
        driver.manage().deleteAllCookies();
        pis("Loading the homepage URL...");
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        
        // Close the extension settings window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        driver.close();
        
        //Get back to the window with the web
        driver.switchTo().window((String) windowHandles[0]);
        
        // Go to the Signup / Login page
        pis("Clicking the link 'Signup / Login'...");
        hp.clickLoginPage();
        
        // Handle the GDPR overlay
        handleGDPR();
    }
    
    private void handleGDPR() {
        try {
      		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.elementToBeClickable(hp.getSuhlasBtn()));
        } catch (Exception e) {
            			System.out.println("GDPR popup not found or unable to click.");
        			}
        //closing the first curly brace in the function:
    				}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

  //definition of global variables
    String[] fnames = {"Joe", "Sam", "Ann", "Jim", "Cam", "Linn", "Pam"};
    String[] countries = {"India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"};
    String[] streets = {"Street", "Drive", "Road"};

//definition of custom reusable methods

	public void myWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//defines implicit wait for a particular element with time setting
	public void waitForElement(WebElement element, int time) {
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(time)); // declaration
		WebElement elementFinal = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.getText())));	
	}
	
	public void pis(String text) {
		System.out.println(text);
	}
	
	//has to be a String!
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	//has to be a string!
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	

	public String generateStartLetter() {
	    // characters to choose from:
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    
	    //initiates the classes
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    
	    // specifies the string length
	    int stringLength = 1;
	    
	    for (int i = 0; i < stringLength; i++) {
	        //generates random index number
	        int index = random.nextInt(alphabet.length());
	        char randomChar = alphabet.charAt(index);
	        sb.append(randomChar);
	    }
	    return sb.toString();
	}

	public String generateString(int length) {
	    //characters for selection
		String alphabet = "abcdefghijklmnopqrstuwyxz";
	    
		//Initializes the necessary objects
		StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	
	    //generates the specified number of random characters
	    for (int i = 0; i < length; i++) {
	        int index = random.nextInt(alphabet.length());
	        char randomChar = alphabet.charAt(index);
	
	        //adds up each generated random character
	        sb.append(randomChar);
	    }
	    return sb.toString();	
	}

        public String generateSpecialChar(int length){
		String characterList ="`~@#$%^&*()_-=+[{]};:'\\|,<.>/?£!? ";
	
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
	
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characterList.length());
			char randomCharacter = characterList.charAt(index);
			sb.append(randomCharacter);
		}
		return sb.toString();
	}

	public int generateNumber(int min, int max) {
	    //generates a random integer greater than the min value specified and lower than or same as the  max value specified
		return (int)(Math.random() * (max - min + 1) + min);
	}

}