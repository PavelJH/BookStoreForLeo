package api.tests;


import api.enums.EndPoint;
import api.model.account.AccountDTO;

import api.model.bookStoreDTO.ContactDto;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class ApiBase {
    protected Faker faker = new Faker();
    AccountDTO accountDTO;

    final String BASE_URI = "https://demoqa.com";
    final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkpIIiwicGFzc3dvcmQiOiJKZWZmcnkwODAlIiwiaWF0IjoxNjgzMTE4NjMwfQ.tDU2LAfSj7Pft2GRWiuie6OWAQVF_mpmIqPpk6cf8ZE";

    protected final String ERROR_MESSAGE_FOR_CONTACT = "Error! This contact doesn't exist in our DB";
    protected final String ERROR_MESSAGE_FOR_EMAIL = "Error! This email doesn't exist in our DB";
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

    public Response doPostRequest(EndPoint endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint.getValue())
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doDeleteRequest(EndPoint endPoint, Integer responseCode, ContactDto id){
        Response resp = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endPoint.getValue())
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doGetRequestWithParam(EndPoint endPoint, Integer responseCode, int id){
        Response resp = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", id)
                .log().all()
                .get(endPoint.getValue())
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doGetRequest(EndPoint endPoint, Integer responseCode){
        Response resp = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endPoint.getValue())
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doPutRequest(EndPoint endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .put(endPoint.getValue())
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public AccountDTO createContact() {
        accountDTO = new AccountDTO();
        accountDTO.setUserName("JH");
        accountDTO.setPassword("Jeffry080%");
        return accountDTO;
    }

    public int getWrongId() {
        Random rnd = new Random();
        int wrongId = 100000 + rnd.nextInt(900000);
        return wrongId;
    }


}
