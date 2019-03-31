package interview.sampleProject;

import java.util.Scanner;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestHTTPMethods {
	
	Scanner scan = new Scanner(System.in); //Scan Object
	
	@Test(enabled = false)
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
		System.out.println("Response Time: " + respID.getTime()); //Get the Response Time for the transaction for getting the ID Data
		
	} 
	
	@Test(enabled = false)
	public void postComment() {
		//Validate URL
		Response resp = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments"); //URL for the comment Page
		int codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
		/*
		 * System.out.println("PostID - "); String postID = scan.next();
		 * System.out.println("ID - "); String id = scan.next();
		 * System.out.println("Name - "); String name = scan.next();
		 * System.out.println("Email - "); String email = scan.next();
		 * System.out.println("Body - "); String body = scan.next();
		 */
		
		RequestSpecification request = RestAssured.given();//Need to send multiple parameter 
		request.header("Content-Type","application/json");//type of header
		
		//Putting the user data
		JSONObject json = new JSONObject();
//		json.put("postId", postID);
//		json.put("id", id);
//		json.put("name", name);
//		json.put("email", email);
//		json.put("body", body);
		
		json.put("postId", "150");
		json.put("id", "10000");
		json.put("name", "Shamu");
		json.put("email", "Shamu@gmail.com");
		json.put("body", "Hey Shamu, How are you?");
		
		request.body(json.toJSONString());
		request.post("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments");
		
		codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
	}
	
	@Test(enabled = false)
	public void putUsers() {
		//Validate URL
		Response resp = RestAssured.get("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users"); //URL for the Users Page
		int codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
		
//		  System.out.println("UserName - "); String username = scan.next();
//		  System.out.println("ID - "); String id = scan.next();
//		  System.out.println("Name - "); String name = scan.next();
//		  System.out.println("Email - "); String email = scan.next();
//		 System.out.println("Address - "); String address = scan.next();
		 
		
		RequestSpecification request = RestAssured.given();//Need to send multiple parameter 
		request.header("Content-Type","application/json");//type of header
		
		//Putting the user data
		JSONObject json = new JSONObject();
//		json.put("username", username);
//		json.put("id", id);
//		json.put("name", name);
//		json.put("email", email);
//		json.put("address", address);
		
		json.put("username", "amipavelo");
		json.put("id", "1");
		json.put("name", "Tanbir Mowla");
		json.put("email", "tmowla@gmail.com");
		json.put("address", "6088 Williams Rd, City");	//Need to parse as a JSON array I think..Cz Address Needs to be parsed
		
		request.body(json.toJSONString());
		request.put("http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users/1");
		
		codeURL = resp.getStatusCode(); 
		System.out.println("Get Post URL status code - " + codeURL); 
		Assert.assertEquals(codeURL, 200); //status Code check
		
	}
}
