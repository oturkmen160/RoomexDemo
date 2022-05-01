package com.roomex.step_definitions;

import com.roomex.pages.LoginPage;
import com.roomex.pages.ResetPasswordPage;
import com.roomex.utilities.BrowserUtils;
import com.roomex.utilities.ConfigurationReader;
import com.roomex.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ResetPasswordStepDefs {

    @Given("user is on the reset password page")
    public void user_is_on_the_reset_password_page() {
        LoginPage loginPage = new LoginPage();

        //first go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //then click Forgot password? page
        loginPage.forgotPasswordLink.click();
        //wait reset-password page loads
        BrowserUtils.urlContains("forgot-password",10);
    }

    @When("user enters {string} for email input box")
    public void user_enters_for_email_input_box(String email) {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.inputBox.sendKeys(email);
    }


    @And("clicks Reset Password button")
    public void clicksResetPasswordButton() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.resetPasswordButton.click();
    }


    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        Assert.assertTrue("email address not exist msg displayed",
                resetPasswordPage.isMsgDisplayed(resetPasswordPage.emailNotExistErrorMsg));

    }
}
