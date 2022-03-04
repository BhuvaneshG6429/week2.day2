package assignment.leafground;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundCheckboxPage {

	public static void main(String[] args) {
		
				//setup webdriver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//open url
				driver.get("http://leafground.com/pages/checkbox.html");
				//maximize window
				driver.manage().window().maximize();
				
				//select languages that you know
				driver.findElement(By.xpath("((//div[@class='example'])[1]//input)[1]")).click();
				driver.findElement(By.xpath("((//div[@class='example'])[1]//input)[4]")).click();
				
				//Confirm Selenium is checked
				boolean isChecked = driver.findElement(By.xpath("(//div[@class='example'])[2]//input")).isSelected();
				if(!isChecked) {
					System.out.println("Selenium is not Checked");
				}
				else {
					System.out.println("Selenium is Checked");
				}
				
				//DeSelect only checked
				List<WebElement> deSelectCheckbox = driver.findElements(By.xpath("(//div[@class='example'])[3]//input"));
				for(int i=0;i<deSelectCheckbox.size();i++) {
					if(deSelectCheckbox.get(i).isSelected()) {
						deSelectCheckbox.get(i).click();
					}
					
					
				}
				
				
				//Select all below checkboxes
				List<WebElement> selectAllCheckboxes = driver.findElements(By.xpath("(//div[@class='example'])[4]//input"));
				for(int i=0;i<selectAllCheckboxes.size();i++) {
					
						selectAllCheckboxes.get(i).click();
					
				}
	}

}
