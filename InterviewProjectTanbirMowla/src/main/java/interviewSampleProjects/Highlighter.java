package interviewSampleProjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Hightlighter class does the job to highlight elements before an action
public class Highlighter 
{
	
	public void highlight(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: None; border: 2px solid red;');", element);
	}
	
}
