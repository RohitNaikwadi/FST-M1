package liveProject;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    Map<String, String> header = new HashMap<>();

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        header.put("Content-Type", "application/json");
        DslPart requestResponseBody = new PactDslJsonBody().
                numberType("id", 123).
                stringType("firstName", "Rohit").
                stringType("lastName", "N").
                stringType("email", "rohit.naikwadi@ibm.com");
        return builder.given("POST Request")
                .uponReceiving("request to create user")
                .method("POST")
                .path("/api/users")
                .headers(header)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void consumerTest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Rohit");
        reqBody.put("lastName", "N");
        reqBody.put("email", "rohit.naiwkadi@ibm.com");

        given().baseUri("http://localhost:8282/api/users").headers(header).body(reqBody)
                .when().post().then().statusCode(201);


    }
}
