package RestAssured.Rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
//import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class HttpsCheck {
	//GET request
	@Test(enabled=false)
	public void getAllEmployeeDetails()
	{
		Response response=RestAssured.given()
		.baseUri("http://localhost:3000/")
		.when()
		.get("1");
		System.out.println(response.asPrettyString());
	}
	@Test(enabled=false)
	public void validategetAllEmployeeDetailsStatusLine()
	{
		ValidatableResponse response=RestAssured.given()
		.baseUri("http://localhost:3000/")
		.when()
		.get("1").then();
		System.out.println(response.statusCode(200));
	}

	//POST Request
	@Test(enabled=false)
	public void createmployee() throws IOException
	{
		FileReader file=new FileReader("createemployee.json");
		ValidatableResponse response=RestAssured.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(file)
		.when()
		.post("api/users").then();
		System.out.println(response.statusCode(201));
	}
	
	//Put Request
	@Test(enabled=false)
	public void updateemployeedtail() throws FileNotFoundException
	{
		FileReader file=new FileReader("createemployee.json");
		ValidatableResponse response=RestAssured.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(file)
		.when()
		.put("/api/users/1")
		.then();
		System.out.println(response.statusCode(200));
	}
	
	//Patch Request
	@Test(enabled=false)
	public void updateemployeedetailusingpatch() throws FileNotFoundException
	{
		FileReader file=new FileReader("createemployee.json");
		ValidatableResponse response=RestAssured.given()
		.baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(file)
		.when()
		.patch("/api/users/1")
		.then();
		System.out.println(response.statusCode(200));
		//System.out.println();
	}
	
	//Delete Request
	@Test(enabled=false)
	public void deleteemployeedetails() throws FileNotFoundException
	{
		ValidatableResponse response=RestAssured.given()
		.baseUri("https://reqres.in/")
		.when()
		.delete("/api/users/1")
		.then();
		System.out.println(response.statusCode(204));
		
	}
	@Test(enabled=false)
	public void getemployeedetail() throws FileNotFoundException
	{
		//FileReader file=new FileReader("EmployeeDetails.json");
		Response response=RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("/1");
		System.out.println(response.asPrettyString());
	}
	
	
	
	
	
}
