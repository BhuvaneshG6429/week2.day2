package assignment.leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundEditPage {

	public static void main(String[] args) {
		
		//setup webdriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//open url
				driver.get("http://leafground.com/pages/Edit.html");
				//maximize window
				driver.manage().window().maximize();
				
				//Enter your email address
				driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
				
				//Append a text and press keyboard tab
				driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("text",Keys.TAB);
				
				
				//Get default text entered
				String defaultText=driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
				System.out.println("default text in the textbox is "+defaultText);
				
				//Clear the text
				driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
				
				//Confirm that edit field is disabled
				WebElement textBox = driver.findElement(By.xpath("//label[@for='disabled']/following::input"));
				boolean editStatus=textBox.isEnabled();
				if(!editStatus) {
					System.out.println("text box is disabled");
				}
				
				else {
					System.out.println("text box is enabled");
				}
				

	}

}
