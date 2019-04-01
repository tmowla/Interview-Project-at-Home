package interview.sampleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import interviewSampleProjects.WebApplicationCreateUser;
import interviewSampleProjects.WebApplicationUserFilter;

public class TestWebApplication {
	
	WebDriver chromeDriver = null;
	WebApplicationCreateUser users = null;
	WebApplicationUserFilter filters = null;
	
	@BeforeTest
	public void setUp()	{
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace-02152019\\InterviewProjectTanbirMowla\\Driver\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/");
		chromeDriver.manage().window().maximize();
	}
	
	@Test(enabled = true)
	public void testCreateUser(){
		users = new WebApplicationCreateUser();
		
		users.clickUsers(chromeDriver);
		users.clickNewUser(chromeDriver);
		users.createNewUser(chromeDriver);
	}
	
	@Test(enabled = false)
	public void testUserFilter() throws InterruptedException {
		users = new WebApplicationCreateUser();
		filters = new WebApplicationUserFilter();
		
		users.clickUsers(chromeDriver);
		filters.filterByUsername(chromeDriver);
		filters.filterByEmail(chromeDriver);
		filters.filterByTimeFrame(chromeDriver);
	}

}
