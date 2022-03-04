package assignment.week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//open url
				driver.get("http://leaftaps.com/opentaps/control/login");
				//maximize window
				driver.manage().window().maximize();
		//Enter UserName and Password Using Id Locator
				
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("DemosalesManager");
				
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("crmsfa");
				
				
		//Click on Login Button using Class Locator
				driver.findElement(By.className("decorativeSubmit")).click();
				
		//Click on CRM/SFA Link
				driver.findElement(By.linkText("CRM/SFA")).click();
				
		//Click on contacts Button
				driver.findElement(By.linkText("Contacts")).click();
				
		//Click on Create Contact
				driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		//Enter FirstName Field Using id Locator
				WebElement firstName=driver.findElement(By.id("firstNameField"));
				firstName.sendKeys("Bhuvanesh");
		//Enter LastName Field Using id Locator
				WebElement lastName=driver.findElement(By.id("lastNameField"));
				lastName.sendKeys("G");
		//Enter FirstName(Local) Field Using id Locator
				WebElement firstNameLocal=driver.findElement(By.id("createContactForm_firstNameLocal"));
				firstNameLocal.sendKeys("Bhuvi");
		// Enter LastName(Local) Field Using id Locator
				WebElement lastNameLocal=driver.findElement(By.id("createContactForm_lastNameLocal"));
				lastNameLocal.sendKeys("G");
		// Enter Department Field Using any Locator of Your Choice
				driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Automation");
		// Enter Description Field Using any Locator of your choice 
				driver.findElement(By.id("createContactForm_description")).sendKeys("contact sample description");
		// Enter your email in the E-mail address Field using the locator of your choice
				WebElement mail=driver.findElement(By.id("createContactForm_primaryEmail"));
				mail.sendKeys("bhuvicheck@gmail.com");
		// Select State/Province as NewYork Using Visible Text
				WebElement stateDropdown=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
				Select state = new Select(stateDropdown);
				state.selectByVisibleText("New York");
		// Click on Create Contact
				driver.findElement(By.className("smallSubmit")).click();
		// Click on edit button 
				driver.findElement(By.xpath("//a[text()='Edit']")).click();
		// Clear the Description Field using .clear
				driver.findElement(By.id("updateContactForm_description")).clear();
				driver.findElement(By.id("updateContactForm_description")).sendKeys("updated contact sample description");
		// Fill ImportantNote Field with Any text
				driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is an important note");
		// Click on update button using Xpath locator
				driver.findElement(By.xpath("//input[@value='Update']")).click();
		// Get the Title of Resulting Page.
				System.out.println(driver.getTitle());


	}

}
