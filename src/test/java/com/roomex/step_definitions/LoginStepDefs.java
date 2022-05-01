package com.roomex.step_definitions;

import com.roomex.pages.LoginPage;
import com.roomex.utilities.ConfigurationReader;
import com.roomex.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @When("user clicks Login button")
    public void userClicksLoginButton() {
        LoginPage loginPage = new LoginPage();

        loginPage.loginBtn.click();
    }

    @Then("email error message displayed")
    public void email_error_message_displayed() {
        LoginPage loginPage = new LoginPage();

        Assert.assertTrue("email error msg displayed",
                loginPage.isMsgDisplayed(loginPage.emailErrorMsg));
    }

    @And("password error message displayed")
    public void password_error_message_displayed() {
        LoginPage loginPage = new LoginPage();

        Assert.assertTrue("email error msg displayed",
                loginPage.isMsgDisplayed(loginPage.passwordErrorMsg));
    }

}
