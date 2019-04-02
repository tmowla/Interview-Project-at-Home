package interviewSampleProjects;

import java.util.Scanner;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPMethodsTestCase {
	
	Scanner scan = new Scanner(System.in); 

	public void getPost() {
		//Validate URL
		Response resp = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/posts"); //This is the URL for the Posts Page
		int codeURL = resp.getStatusCode(); //Status Code
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //The status Code check

		//Enter ID
		System.out.print("ID : ");
		String id = scan.next(); //storing ID

		Response respID = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/posts/" + id); //posts page with ID
		codeURL = respID.getStatusCode(); //New Status Code
		System.out.println("Get Post ID URL status code - " + codeURL);
		Assert.assertEquals(codeURL, 200); //status Code check

		String data = respID.asString(); //JSON Object as String
		System.out.println("Data For ID:" + data); 
		System.out.println("Response Time: " + respID.getTime()); //Get the Response Time for the transaction

	} 
	
	
	@SuppressWarnings("unchecked")
	public void postComment() {
		//Validate URL
		Response resp = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments"); //URL for the comment Page
		int codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
		//User Input
		System.out.println("PostID - "); String postID = scan.nextLine();
		System.out.println("ID - "); String id = scan.nextLine();
		System.out.println("Name - "); String name = scan.nextLine();
		System.out.println("Email - "); String email = scan.nextLine();
		System.out.println("Body - "); String body = scan.nextLine();
		 
		
		RequestSpecification request = RestAssured.given();//Need to send multiple parameter 
		request.header("Content-Type","application/json");//type of header
		
		//Put all the user data
		JSONObject json = new JSONObject();
		json.put("postId", postID);
		json.put("id", id);
		json.put("name", name);
		json.put("email", email);
		json.put("body", body);
		
		request.body(json.toJSONString());
		request.post("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments");
		
		//Validate the post
		Response respAfterPost = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments/" + id);
		codeURL = respAfterPost.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void putUsers() {
		//Validate URL
		Response resp = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users"); //URL for the Users Page
		int codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
		RequestSpecification request = RestAssured.given();//Need to send multiple parameter 
		request.header("Content-Type","application/json");//type of header
		
		//Put the user data which needs to be updated. Using id as the primary identifier
		JSONObject json = new JSONObject();
		json.put("username", "alpha");
		json.put("id", "1");
		json.put("name", "Tanbir Mowla");
		json.put("email", "abc@gmail.com");

		JSONObject address = new JSONObject();
		json.put("address", address);
		address.put("Street", "123 Williams Rd");
		address.put("City", "Norcross");
		address.put("State", "GA");
		address.put("Zip", "33333");
		address.put("Phone", "404-000-0000");
		
		request.body(json.toJSONString());
		request.put("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users/1");
		
		Response respAfterPut = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users/1");
		codeURL = respAfterPut.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
	}
}
