package com.roomex.pages;

import com.roomex.utilities.BrowserUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "(//*[@data-qa ='div-error'])[1]/div")
    public WebElement emailErrorMsg;

    @FindBy(xpath = "(//*[@data-qa ='div-error'])[2]/div")
    public WebElement passwordErrorMsg;

    @FindBy(xpath = "//a[@href = '/forgot-password']")
    public WebElement forgotPasswordLink;

}
