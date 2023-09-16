package example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp()
    {
        //Request Spec
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2/pet").
                addHeader("Content-Type","application/json").
                build();

        //Response Spec
        responseSpec= new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThanOrEqualTo(5000L)).
                build();
    }

    @Test(priority = 1)
    public void postRequestTest()
    {
        //Req body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 9090);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        Response response=given().spec(requestSpec).body(reqBody).when().post();
        petId=response.then().extract().path("id");
        System.out.println(petId);
    }

    @Test(priority = 2)
    public void getRequestTest()
    {
        given().spec(requestSpec).pathParam("petId",petId).when().get("/{petId}").then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest()
    {
        given().spec(requestSpec).pathParam("petId",petId).when().delete("/{petId}").then().spec(responseSpec);
    }
}
