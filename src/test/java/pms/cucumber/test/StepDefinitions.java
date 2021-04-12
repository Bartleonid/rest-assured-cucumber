package pms.cucumber.test;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import com.pms.common.Utility;
import com.pms.data.User;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class StepDefinitions {
	private static Response response;
	private static String jsonString;
	private final static String URI = "https://www.google.com/";
	private final Map<String, String> map = new HashMap<>();

	@Given("I am authorized")
	public void getCookie() {
		String cookie = null;
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		final JSONObject requestParams = new JSONObject();
		requestParams.put("username", User.getUser());
		requestParams.put("password", User.getPassword());
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		final Response response = request.post("/api/login");
		final int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		cookie = Utility.extractValueByRegex(response.header("Authorization"), "(.*)", 1);
		map.put("cookie", cookie);
		response = request.get("");
		jsonString = response.asString();
	}

	@When("I add Phone")
	public void addPhone() {
		String jsonString = "";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(jsonString);
	}

	@Then("Status code is {int}")
	public void bookIsAdded(Integer int1) {
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println(response.getStatusCode());
	}

}
