package assignment.leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundButtonPage {

	public static void main(String[] args) {
		
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://leafground.com/pages/Button.html");
		//maximize window
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		System.out.println("moved to home page");
		
		//going back to button page to interact with remaining buttons
		driver.navigate().back();
		
		//Find position of button (x,y)
		System.out.println("Location of the button is "+driver.findElement(By.id("position")).getLocation());
		
		//Find button color
		System.out.println("color of the button is "+driver.findElement(By.id("color")).getCssValue("color"));
		
		//Find the height and width
		System.out.println("size of the button is "+driver.findElement(By.id("size")).getSize());

	}

}
