package assignment.week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("https://en-gb.facebook.com/");
		//maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//click on create new account
		driver.findElement(By.linkText("Create New Account")).click();
		
		//enter first name
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("myFirstName");
		
		//enter last name
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("myLastName");
		
		//enter mail
		WebElement mailAddress = driver.findElement(By.name("reg_email__"));
		mailAddress.sendKeys("myMail");
		
		//enter new password
		WebElement password = driver.findElement(By.id("password_step_input"));
		password.sendKeys("encryptedcode");
		
		//select Day from dropdown
		WebElement dayOfBirth = driver.findElement(By.id("day"));
		Select selectDay = new Select(dayOfBirth);
		selectDay.selectByIndex(2);
		
		//select month from dropdown
		WebElement monthOfBirth = driver.findElement(By.id("month"));
		Select selectMonth = new Select(monthOfBirth);
		selectMonth.selectByVisibleText("Dec");
		
		//select year from dropdown
		WebElement yearOfBirth = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearOfBirth);
		selectYear.selectByValue("1995");
		
		//select gender radio button
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		//wait to display for sometime
		Thread.sleep(3000);
		
		//close the browser
		driver.close();
		

	}

}
