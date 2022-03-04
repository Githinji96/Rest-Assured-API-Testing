package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExamples {
@Test
  public void testGet(){
	baseURI= "https://reqres.in/api";
	given().get("/users?page=2").then().statusCode(200).
	body("data[5].first_name",equalTo("Rachel")).
	body("data.first_name",hasItems("Rachel","Lindsay"));
}
   @Test
   public void testPost() {
	Map<String,Object>map= new HashMap<String,Object>();
	//map.put("name", "Raghav");
	//map.put("job", "software Engineer");
	
	//System.out.println(map);
	
	JSONObject request= new JSONObject();
	request.put("name","Raghav");
	request.put("job", "software engineer");
	System.out.println(request.toJSONString()); 
	baseURI= "https://reqres.in/api";
	given().
	body(request.toJSONString()).
	when().
	post("/users").
	then().
	statusCode(201).log().all();
	}
}
