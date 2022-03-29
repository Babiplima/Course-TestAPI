import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

package com.thecat.TestAPI;

import org.junit.Test;

public class TesteAPI {
	
@Test
public void cadastro() {
	
	String url = "https://api.thecatapi.com/v1/user/passwordlesssignup";
	String corpo = "{\"email\": \"babiplima@gmail.com\", \"appDescription\": \"teste the cat\"}";
	
	//DADO QUE 
	Response response = given().contentType("application/json").body(corpo).
		
	when().post(url);
	
	response.then().body("message", containsString("SUCCESS")).statusCode(200);
	
	System.out.println("RETORNO => " + response.body().asString());
   }

@Test
public void votacao() {
	
	String url = "https://api.thecatapi.com/v1/votes/";
		
	//DADO QUE 
	Response response = 
			given().contentType("application/json")
			.body("{\"image_id\": \"au7\", \"value\": \"true\", \"sub_id\": \"demo-ef68c3\"}").
		when().post(url);
	
	response.then().body("message", containsString("SUCCESS")).statusCode(200);
	
	System.out.println("RETORNO => " + response.body().asString());
	String id = response.jsonPath().getString("id");
	System.out.println("ID => " + id);

   }
}