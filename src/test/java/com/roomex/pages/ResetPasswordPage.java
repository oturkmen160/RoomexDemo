package com.roomex.pages;

import com.roomex.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage{

    @FindBy(tagName = "input")
    public WebElement inputBox;

    @FindBy(tagName = "button")
    public WebElement resetPasswordButton;

//    @FindBy(xpath = "//rx-alert/div")
//    public WebElement emailNotExistErrorMsg;

    public WebElement getEmailNotExistErrorMsgElement(){
        WebElement emailNotExistErrorMsgElement = null;
        try {
            emailNotExistErrorMsgElement = Driver.get().findElement(By.xpath("//rx-alert/div"));
        }catch (Exception e){}
        return emailNotExistErrorMsgElement;
    }

}
