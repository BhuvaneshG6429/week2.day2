package assignment.week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem1 {

	public static void main(String[] args) {
		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("https://acme-test.uipath.com/login");
		//maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter mail
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kumar.testleaf@gmail.com");
		
		//enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("leaf@12");
		
		//click Login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//get Title and print
		
		System.out.println(driver.getTitle());
		
		//click Logout
		driver.findElement(By.linkText("Log Out"));
		
		//close the browser
		driver.close();
		

	}

}
