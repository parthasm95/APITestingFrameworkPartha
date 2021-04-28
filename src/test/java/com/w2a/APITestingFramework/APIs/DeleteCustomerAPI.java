package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setup.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String,String> data) {
		
	
		// inside Delete Customer API
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
		
		return response;
	}

}
