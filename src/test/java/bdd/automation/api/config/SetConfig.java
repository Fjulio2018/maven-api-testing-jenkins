package bdd.automation.api.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetConfig {

    private static String rickAndMortyBaseUri = "https://rickandmortyapi.com";
    private JsonPath lastJsonPath;

    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(rickAndMortyBaseUri)
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    public static String getRickAndMortyBaseUri() {
        return rickAndMortyBaseUri;
    }

    public void setLastJsonPath(JsonPath jsonPath) {
        this.lastJsonPath = jsonPath;
    }

    public JsonPath getLastJsonPath() {
        return lastJsonPath;
    }
}
