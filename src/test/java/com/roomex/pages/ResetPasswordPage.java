package com.roomex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage{

    @FindBy(tagName = "input")
    public WebElement inputBox;

    @FindBy(tagName = "button")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//rx-alert/div")
    public WebElement emailNotExistErrorMsg;


}
