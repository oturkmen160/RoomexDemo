package com.roomex.api.services;

import com.roomex.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected static RequestSpecification defaultRequestSpecification(){
        return restAssured()
                .header("Content-type", "application/json");
    }

    protected static RequestSpecification restAssured(){
        RestAssured.baseURI = ConfigurationReader.get("apiBaseURI");

        return given()
                .log().all()
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
    }
}