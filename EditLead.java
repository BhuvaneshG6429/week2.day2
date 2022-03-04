package assignment.week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize window
		driver.manage().window().maximize();
		
		//apply wait
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
		
		//enter first Name in text box by identifying element using xpath axes
		
		driver.findElement(By.xpath("//input[@name='id']/following::input[@name='firstName']")).sendKeys("Bhuvanesh");
		
		//click on find leads button
		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		//click on first resulting lead
		
		driver.findElement(By.xpath("(//span[contains(text(),'Lead List')]//following::a[@class='linktext'])[1]")).click();
		
		//verify page title
		String title = driver.getTitle();
		
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("title is verified as correct");
		}
		else {
			System.out.println("title is verified as incorrect");
		}
		
		//click on Edit
		
		driver.findElement(By.linkText("Edit")).click();
		
		//change company name
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		
		String newCompanyName = "CTS India";
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCompanyName);
		
		//click on update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//check updated company name
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(updatedCompanyName.contains(newCompanyName)) {
			System.out.println("company name is updated");
		}
		else {
			System.out.println("company name is not updated correctly");
		}
		
		//close the browser
		driver.close();
		
	}

}
