package RestAssured.Rest;

import org.testng.annotations.Test;



import io.restassured.RestAssured;


import static org.hamcrest.Matchers.*;

public class HamcrestMatchersValidation {
	@Test(enabled=false)
	public void validateidfromJson()
	{
		RestAssured.given().baseUri("http://localhost:3000/")
		.when().get("0").then().
		body("id", equalTo(1));
	}
	@Test(enabled=false)
	public void validateemailfromJson()
	{
		RestAssured.given().baseUri("http://localhost:3000/")
		.when().get("0").then().
		body("name", equalTo("John Doe"));
	}
	@Test(enabled=false)
	public void validateaddressfromJson()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("/0").then().assertThat().and()
		.body("addressDetails.addressLine1", equalTo("Mgr Road"))
		.and()
		.body("addressDetails.houseNumber", containsString("H-56"))
		.and()
		.body("addressDetails.landmark", endsWith("shop")).
		and()
		.body("name", startsWith("John")).
		and()
		.body("dob",equalToIgnoringWhiteSpace(" 17-10-95"))
		.and()
		.body("addressDetails.addressLine1",equalToIgnoringCase("MGR ROAD"));
	}
	
	@Test(enabled=false)
	public void validateObjectfromJson()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("/0").then().assertThat().and()
		.body("addressDetails", hasKey("houseNumber"))
		.and()
		.body("addressDetails", hasValue("EMP-21235"))
		.and()
		.body("addressDetails", hasEntry("office pincode",3318901))
		.and()
		.body("addressDetails.landmark", hasItem("Near Nilgirs shop"))
		.and()
		.body("addressDetails.landmark",hasItems("Mandaveli porum mall","Near Nilgirs shop"));
	}
	
	@Test(enabled=true)
	public void validateNumericfromJson()
	{
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("/1").then().assertThat()
		.and().body("addressDetails.officepincode", lessThanOrEqualTo(999000))
		.and()
		.body("addressDetails.aadharNumber",greaterThanOrEqualTo(120000));
	}

}
