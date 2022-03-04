package assignment.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundImagePage {

	public static void main(String[] args) {
		

		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://leafground.com/pages/Image.html");
		//maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on img to go to home page
		driver.findElement(By.xpath("(//label[@for='home']/following::img)[1]")).click();
		
		//go to back to image page to interact with remaining elements
		driver.navigate().back();
		
		//check for broken image
		WebElement image = driver.findElement(By.xpath("(//label[@for='home']/following::img)[2]"));
		if(image.getAttribute("naturalWidth").equals("0")) {
			System.out.println("image is broken");
		}
		
		else {
			System.out.println("image is valid");
		}
		
		//click img using mouse
		WebElement imageLink1 = driver.findElement(By.xpath("(//label[@for='home']/following::img)[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(imageLink1).click().build().perform();
		
		//go to back to image page to interact with remaining elements
		driver.navigate().back();
		
		
	}

}
