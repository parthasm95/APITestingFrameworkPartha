package com.w2a.APITestingFramework.testcases;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.DeleteCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setup.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFramework.utilities.TestUtil;

import io.restassured.response.Response;

@Test(dataProviderClass = DataUtil.class,dataProvider = "data")
public class DeleteCustomerTest extends BaseTest{
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
		response.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());
		System.out.println(response.statusCode());
		
		/*
		 * String actual_id = response.jsonPath().get("id").toString();
		 * System.out.println("GEtting id from Json Path : "+actual_id);
		 * Assert.assertEquals(actual_id, data.get("id"),"ID does not match");
		 */
		
		System.out.println("Presence Check for Object Key : "+ TestUtil.jsonHasKey(response.asString(),"object"));
		System.out.println("Presence Check for Deleted Key : "+ TestUtil.jsonHasKey(response.asString(),"deleted"));
		
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(),"id"), "ID key is not present in JSON Response");
		
		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
		System.out.println("Getting id from Json Path : "+actual_id);
		Assert.assertEquals(actual_id, data.get("id"),"ID does not match");
		
		System.out.println("Object Key value is : "+TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted Key value is : "+TestUtil.getJsonKeyValue(response.asString(), "deleted"));
		Assert.assertEquals(response.statusCode(), 200);
	}

}
