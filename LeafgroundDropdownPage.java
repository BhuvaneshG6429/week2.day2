package assignment.leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundDropdownPage {

	public static void main(String[] args) {
		//setup webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://leafground.com/pages/Dropdown.html");
		//maximize window
		driver.manage().window().maximize();
		
		//select by index
		WebElement d1 = driver.findElement(By.id("dropdown1"));
		Select dropdown1 = new Select(d1);
		dropdown1.selectByIndex(1);
		
		//select by text
		WebElement d2 = driver.findElement(By.name("dropdown2"));
		Select dropdown2 = new Select(d2);
		dropdown2.selectByVisibleText("Selenium");
		
		//select by value
		WebElement d3 = driver.findElement(By.name("dropdown3"));
		Select dropdown3 = new Select(d3);
		dropdown3.selectByValue("1");
		
		//get number of dropdown options
		WebElement d4=driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dropdown4 = new Select(d4);
		System.out.println(dropdown4.getOptions().size());
		
		//use sendkeys for select
		WebElement d5=driver.findElement(By.xpath("(//select)[5]"));
		d5.sendKeys("Selenium");
		
		//select multiple
		WebElement d6=driver.findElement(By.xpath("(//select)[6]"));
		Select multiple = new Select(d6);
		multiple.selectByIndex(1);
		multiple.selectByIndex(3);
		multiple.selectByIndex(4);
		
	}

}
