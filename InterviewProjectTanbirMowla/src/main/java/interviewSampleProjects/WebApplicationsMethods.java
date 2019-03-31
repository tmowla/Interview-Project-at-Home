package interviewSampleProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebApplicationsMethods 
{
	
	//WebDriver chromeDriver = null;
	
	ClassHighlighter hltObj = new ClassHighlighter();
	
	WebDriverWait waitTime = null; //Initiate to null at the Beginning
	
	public String pageTitleOfThePage(WebDriver driver)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Workspace-02152019\\InterviewProjectTanbirMowla\\Driver\\chromedriver.exe");
		//chromeDriver = new ChromeDriver();
		//chromeDriver.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/");
		//chromeDriver.manage().window().maximize();
		
		String page_Title = null;
		//waitTime = new WebDriverWait(chromeDriver, 20);
		
		//waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.id("page_title")));
		WebElement ele = driver.findElement(By.id("page_title"));
		page_Title = ele.getAttribute("innerText");
		
		return page_Title;
	}
	
	
	
	public void clickTheUsersTab(WebDriver driver)
	{
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		WebElement ele = driver.findElement(By.linkText("Users"));
		hltObj.highlight(driver, ele);
		ele.click();
	}
	
	public void clickNewUser(WebDriver driver)
	{
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New User")));
		WebElement ele = driver.findElement(By.linkText("New User"));
		hltObj.highlight(driver, ele);
		ele.click();
	}
	
	public void createNewUser(WebDriver driver)
	{
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='label']")));
		if (driver.findElements(By.xpath("//label[@class='label']")).size() > 0)
		{
			List <WebElement> Label = driver.findElements(By.xpath("//label[@class='label']"));
			for (int counterLabel = 0; counterLabel <  Label.size(); counterLabel++)
			{
				if (Label.get(counterLabel).getAttribute("innerText").equals("Username"))
				{
					String userName_for = Label.get(counterLabel).getAttribute("for");
					System.out.println(userName_for);
				}
			}
			
		}
		
		
		
		
		
	}
}
