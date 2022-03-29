package com.thecat.TestAPI;

import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SuppressWarnings("unused")
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
}
