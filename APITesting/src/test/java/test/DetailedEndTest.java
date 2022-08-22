package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DetailedEndTest {
	@BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
	 @Test
	    public void getRequest() { // get Request 
	        Response response = given().contentType(ContentType.JSON).when().get("/posts").then().extract().response();
	             System.out.println(response.getBody().asString());

	        Assertions.assertEquals(200, response.statusCode());
	        Assertions.assertEquals("ea molestias quasi exercitationem repellat qui ipsa sit aut", response.jsonPath().getString("title[2]"));
	    }

	 
}
