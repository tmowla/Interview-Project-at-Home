package interviewSampleProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WebApplicationCreateUser {

	Highlighter highLighter = new Highlighter();
	WebDriverWait waitTime = null;
	String username = "tmowla";
	String passWord = "123456";
	String emailAdd = "tmowla@yahoo.com";
	
	//Method to test clicking Users tab
	public void clickUsers(WebDriver driver){
		waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		WebElement element = driver.findElement(By.linkText("Users"));
		highLighter.highlight(driver, element);
		element.click();
	}
	
	//Method to test clicking New User tab
	public void clickNewUser(WebDriver driver)
	{
		waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New User")));
		WebElement element = driver.findElement(By.linkText("New User"));
		highLighter.highlight(driver, element);
		element.click();
	}
	
	//Method to input the necessary info to create an user  
	public void createNewUser(WebDriver driver){
		waitTime = new WebDriverWait(driver, 10);
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.id("page_title")));
		
		WebElement userName = driver.findElement(By.id("user_username"));
		highLighter.highlight(driver, userName);
		userName.sendKeys(username);
		
		WebElement password = driver.findElement(By.id("user_password"));
		highLighter.highlight(driver, password);
		password.sendKeys(passWord); 
		
		WebElement email = driver.findElement(By.id("user_email"));
		highLighter.highlight(driver, email);
		email.sendKeys(emailAdd); 
		
		WebElement createUserBtn = driver.findElement(By.name("commit")); 
		highLighter.highlight(driver, createUserBtn);
		createUserBtn.click();
		
		//Validate the confirmation page to create a new user
		WebElement userTitle = driver.findElement(By.id("page_title"));
		String pageTitle = userTitle.getAttribute("innerText");
		highLighter.highlight(driver, userTitle);
		Assert.assertEquals(username, pageTitle);
	}
}
