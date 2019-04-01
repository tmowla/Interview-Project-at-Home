package interviewSampleProjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WebApplicationUserFilter {
	Highlighter highLighter = new Highlighter();
	WebDriverWait waitTime = null;
	
	public void filterByUsername(WebDriver driver) throws InterruptedException {
		waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		
		//username dropdown test
		WebElement element = driver.findElement(By.xpath("//*[@id=\"q_username_input\"]/select"));
		highLighter.highlight(driver, element);
		element.sendKeys("Equals");
		element.sendKeys(Keys.RETURN);

		//username input
		WebElement usernameInput = driver.findElement(By.id("q_username"));
		usernameInput.sendKeys("alpha");
		highLighter.highlight(driver, usernameInput);
		
		//filter button test
		WebElement filterButton = driver.findElement(By.xpath("//input[@name='commit']"));
		highLighter.highlight(driver, filterButton);
		filterButton.click();
		
		//Validate the confirmation page for the specific filter
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_171\"]/td[3]"));
		String attribute = userName.getAttribute("innerText");
		highLighter.highlight(driver, userName);
		Assert.assertEquals("alpha", attribute);
	}
	
	
	
	public void filterByEmail(WebDriver driver) {
		waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		
		//email dropdown test
		WebElement element = driver.findElement(By.xpath("//*[@id=\"q_email_input\"]/select"));
		highLighter.highlight(driver, element);
		element.sendKeys("Equals");
		element.sendKeys(Keys.RETURN);
		
		//user input
		WebElement usernameInput = driver.findElement(By.id("q_email"));
		usernameInput.sendKeys("abc@yahoo.com");
		highLighter.highlight(driver, usernameInput);
		
		//filter button test
		WebElement filterButton = driver.findElement(By.xpath("//input[@name='commit']"));
		highLighter.highlight(driver, filterButton);
		filterButton.click();
		
		//Validate the confirmation page for specific filter
		WebElement email = driver.findElement(By.xpath("//*[@id=\"user_171\"]/td[4]"));
		String attribute = email.getAttribute("innerText");
		highLighter.highlight(driver, email);
		Assert.assertEquals("abc@yahoo.com", attribute);
	}
	
	public void filterByTimeFrame(WebDriver driver) {
		
		//When we explicitly wait for the element for 20 seconds it may be 20 seconds until the page loads, so we get a null pointer exception or unable to locate the element, 
		//depanding the amount of data I wanted to make sure we dont get a nullpointer exception/ timeout exception.
		//This while loop which wait for the element upto 10 seconds to find it and does not break until it do 
		//And if we know the list of data exist and it taking time to displayed, we will be able to increase the time limit, because it already came out of the loop.
		
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		long timeElapsed = 0;
		long timeElapsedinSeconds = 0;
		
		//it waits for the element to display, if it can not find the element it agains come inside try block of while loop to look for the element, but if it finds then breaks the while loop.
		while(timeElapsedinSeconds < 10) {
			try{
				if(driver.findElement(By.xpath("//*[@id=\"q_created_at_gteq_datetime\"]")).isDisplayed()){
					if (driver.findElement(By.xpath("//*[@id=\"q_created_at_lteq_datetime\"]")).isDisplayed()){
						WebElement dateWidgetFrom = driver.findElement(By.xpath("//*[@id=\"q_created_at_gteq_datetime\"]"));
						highLighter.highlight(driver, dateWidgetFrom);
						dateWidgetFrom.sendKeys("2019-03-01");
						dateWidgetFrom.sendKeys(Keys.RETURN);
						
						WebElement dateWidgetTo = driver.findElement(By.xpath("//*[@id=\"q_created_at_lteq_datetime\"]"));
						highLighter.highlight(driver, dateWidgetTo);
						dateWidgetTo.sendKeys("2019-04-01");
						dateWidgetTo.sendKeys(Keys.RETURN);
						
						WebElement filterButton = driver.findElement(By.xpath("//input[@name='commit']")); 
						highLighter.highlight(driver, filterButton);
						filterButton.click();
						break;
					}			
				}
			}catch (Exception exp){
				endTime = System.currentTimeMillis();
				timeElapsed = endTime - startTime;
				timeElapsedinSeconds = TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
				if(timeElapsedinSeconds > 10){
					System.out.println("Took more than 10 seconds");
					exp.printStackTrace();
				}
			}
		}
	}
}
