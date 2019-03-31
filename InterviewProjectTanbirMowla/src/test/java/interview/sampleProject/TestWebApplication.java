package interview.sampleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import interviewSampleProjects.WebApplicationsMethods;

public class TestWebApplication {
	
	WebDriver chromeDriver = null;
	WebApplicationsMethods actions = null;
	
	@BeforeTest
	public void setUp()
	
	{
		//ChromeDriverManager.getInstance().setup();
		//System.out.println("hello");
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace-02152019\\InterviewProjectTanbirMowla\\Driver\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/");
		chromeDriver.manage().window().maximize();
		
		//chromeDriver.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/");
		//chromeDriver.manage().window().maximize();
		//
	}
	
	@Test(enabled = true)
	public void testWebApplication()
	{
		actions = new WebApplicationsMethods();
		
		//String pageT = 
		//Assert.assertEquals(pageT, "Dashboard");
		//actions.clickTheUsersTab();
		//actions.clickNewUser();
		//actions.createNewUser();	
	}

}
