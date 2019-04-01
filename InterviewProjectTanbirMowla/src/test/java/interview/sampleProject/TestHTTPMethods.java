package interview.sampleProject;

import org.testng.annotations.Test;
import interviewSampleProjects.HTTPMethodsTestCase;

public class TestHTTPMethods {
	HTTPMethodsTestCase actions = null;
	
	@Test(enabled = true)
	public void testHTTPMethods(){
		actions = new HTTPMethodsTestCase();
		
		actions.getPost();
		actions.postComment();
		actions.putUsers();
	}
}
