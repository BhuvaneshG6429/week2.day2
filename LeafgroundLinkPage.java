package assignment.leafground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundLinkPage {

	public static void main(String[] args) {
		
				//setup webdriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//open url
				driver.get("http://leafground.com/pages/Link.html");
				//maximize window
				driver.manage().window().maximize();
				
				//Go to Home Page
				driver.findElement(By.linkText("Go to Home Page")).click();
				System.out.println("moved to home page");
				
				//go back to link page to interact with remaining links
				driver.navigate().back();
				
				//Find where am supposed to go without clicking me?
				System.out.println("This link is supposed to go to "+driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
				
				//Verify am I broken?
				driver.findElement(By.linkText("Verify am I broken?")).click();
				String title = driver.getTitle();
				if(title.contains("404")) {
					System.out.println("The link is broken");
				}
				
				else {
					System.out.println("The link is valid");
				}
				
				//go back to link page to interact with remaining links
				driver.navigate().back();
				
				//Go to Home Page (Interact with same link name)
				driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
				
				//go back to link page to interact with remaining links
				driver.navigate().back();
				
				//How many links are available in this page?
				List<WebElement> links = driver.findElements(By.tagName("a"));
				System.out.println("Total number of links in the page is "+links.size());
	}

}
