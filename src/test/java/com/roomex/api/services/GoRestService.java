package com.roomex.api.services;

import io.restassured.response.Response;
import static com.roomex.api.services.BaseService.*;
import static com.roomex.api.functions.apiFunctions.randomPostNum;

public class GoRestService {

    public static Response getAPost(){
        return defaultRequestSpecification()
                .pathParam("postNum", randomPostNum(100) )
                .when()
                .get("/posts/{postNum}/comments");
    }

}
