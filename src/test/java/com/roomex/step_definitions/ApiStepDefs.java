package com.roomex.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.roomex.api.services.GoRestService.*;
import static com.roomex.api.functions.apiFunctions.*;

public class ApiStepDefs {

    private static Response response;


    @When("get request for a random post")
    public void get_request_for_a_random_post() {
        response = getAPost();

    }

    @Then("each comment has an email address")
    public void each_comment_has_an_email_address() {
        List<Map<String, Object>> listOfComments = response.body().as(List.class);


        //checking negatives
        //listOfComments.get(0).replace("email", null);
        //listOfComments.get(0).replace("email", "");
        //listOfComments.get(0).replace("email","xyz");


        Assert.assertTrue("a comment email is null", hasEmailValue(listOfComments));
        Assert.assertTrue("a comment has not valid email", hasValidEmailValue(listOfComments));
    }


}
