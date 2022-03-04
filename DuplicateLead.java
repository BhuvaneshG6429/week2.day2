package assignment.week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize window
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemosalesManager");
		//enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//click Login button
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		//click CRM/SFA linkText
		WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SFA"));
		linkTextCRM.click();
		
		//click Leads
		WebElement leads = driver.findElement(By.linkText("Leads"));
		leads.click();
		
		//click on Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//enter email
		driver.findElement(By.xpath("//span[text()='Email']/following::input[@name='emailAddress']")).sendKeys("bhuvicheck@gmail.com");
		
		//click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Capture name of First Resulting Lead
		WebElement leadList = driver.findElement(By.xpath("(//span[contains(text(),'Lead List')]//following::a[@class='linktext'])[3]"));
		String capturedName = leadList.getText();
		System.out.println("Captured name is "+capturedName);
		
		//click on First Resulting Lead
		leadList.click();
		
		//click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//verify page title
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead")) {
			System.out.println("title is verified as correct");
		}
		
		else {
			System.out.println("title is verified as incorrect");
		}
		
		//click on create lead
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//confirm duplicated name is same as captured name
		String duplicatedName=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Duplicated name is "+duplicatedName);
		if(capturedName.equals(duplicatedName)) {
			System.out.println("Duplicated name is same as captured name");
		}
		else {
			System.out.println("Duplicated name is not same as captured name");
		}
		
		//close the browser
		driver.close();
		
	}

}
