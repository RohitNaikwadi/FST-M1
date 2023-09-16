package example;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class FirstTest {


    @Test
    public void getRequestWithQuery()
    {
        Response response=
        given().header("Content-Type","application/json").queryParam("status","available").log().all()
        .when().get("https://petstore.swagger.io/v2/pet/findByStatus");

       System.out.println(response.getBody().asString());
        //System.out.println(response.getHeaders().asList());
        assertEquals(response.then().extract().body().path("[0].name"),"Dog");

    }



    public void getRequestWithPathParam()
    {
                        /*given().header("Content-Type","application/json").pathParam("petId","9223372016900013000")
                        .when().get("https://petstore.swagger.io/v2/pet/{petId}")
                        .then().statusCode(200).body("name",equalTo("Dog")).log().ifValidationFails();*/



    }



    public void deletePet()
    {
        given().header("Content-Type","application/json").pathParam("petId","2").log().all()
                .when().delete("https://petstore.swagger.io/v2/pet/{petId}")
                .then().statusCode(200).log().body();
    }


    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addNewPet() throws IOException {
        // Import JSON file
        File file = new File("src/test/resorces/input.json");
        FileInputStream inputJSON = new FileInputStream(file);
        // Get all bytes from JSON file
        byte[] bytes = new byte[(int) file.length()];
        inputJSON.read(bytes);
        // Read JSON file as String
        String reqBody = new String(bytes, "UTF-8");

        System.out.println(reqBody);

        Response response = given()
                .contentType(ContentType.JSON) // Set headers
                .body(reqBody) // Pass request body from file
                .when().post(ROOT_URI); // Send POST request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        inputJSON.close();

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
    }

}
