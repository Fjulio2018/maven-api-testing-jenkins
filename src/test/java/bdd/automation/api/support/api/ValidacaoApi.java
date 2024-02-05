package bdd.automation.api.support.api;

import bdd.automation.api.config.SetConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ValidacaoApi {

    private static final String FIND_ORDER_BY_STATUS_ENDPOINT = "/api/character/";



    public static String getIndividuoByStatus(SetConfig config, String name, String status) {
        String response =
                given()
                        .param("name", name)
                        .param("status", status)
                        .when()

                        .get(SetConfig.getRickAndMortyBaseUri() + FIND_ORDER_BY_STATUS_ENDPOINT)
                        .then()
                        .extract().body().jsonPath().toString();
        return response;
    }
    public static JsonPath getIndividuoByStatusJ(SetConfig config, String name, String status) {
        Response response =
                given()
                        .param("name", name)
                        .param("status", status)
                        .when()
                        .get(config.getRickAndMortyBaseUri() + FIND_ORDER_BY_STATUS_ENDPOINT)
                        .then()

                        //.log().all()
                        .extract().response();
        return response.jsonPath();
    }


    public static void validarEsquema(String nomeArquivo) {



        final String URI_GET_BY_ID = "https://rickandmortyapi.com/api/character/10";
        given()
                .when()
                .get(URI_GET_BY_ID)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/"+nomeArquivo+".json"))
        ;

    }

}
