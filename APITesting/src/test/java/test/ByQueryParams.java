package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ByQueryParams {
	 @BeforeAll
	    public static void setup() {
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	 }
	   	 @Test
	   	    public void getRequestWithQueryParam() { // get Request by Query parameter 
	   	        Response response = given().contentType(ContentType.JSON).param("postId", "2").when().get("/comments").then().extract().response();
	   	     System.out.println(response.getBody().asString());
	   	        Assertions.assertEquals(200, response.statusCode());
	   	        Assertions.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
	   	    }
	  
}
