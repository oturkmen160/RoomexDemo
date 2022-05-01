package com.roomex.pages;

import com.roomex.utilities.BrowserUtils;
import com.roomex.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

//    @FindBy(xpath = "(//*[@data-qa ='div-error'])[1]/div")
//    public WebElement emailErrorMsg;
//
//    @FindBy(xpath = "(//*[@data-qa ='div-error'])[2]/div")
//    public WebElement passwordErrorMsg;

    @FindBy(xpath = "//a[@href = '/forgot-password']")
    public WebElement forgotPasswordLink;

    public WebElement getErrorMsgElement(String errorMsgLocation){
        WebElement errorMsgElement = null;
        switch (errorMsgLocation){
            case "email":
                try {
                    errorMsgElement = Driver.get().findElement(By.xpath("(//*[@data-qa ='div-error'])[1]/div"));
                }catch (Exception e){
                    System.out.println("Error Message is not displayed!");
                }
                break;
            case "password":
                try {
                    errorMsgElement = Driver.get().findElement(By.xpath("(//*[@data-qa ='div-error'])[2]/div"));
                }catch (Exception e){
                    System.out.println("Error Message is not displayed!");
                }
                break;
        }
        return errorMsgElement;
    }

    public String getErrorMsg(String errorMsgLocation){
        if (getErrorMsgElement(errorMsgLocation) != null){
            return getErrorMsgElement(errorMsgLocation).getText();
        }
        return null;
    }

    public void navigateForgotPasswordPage(){
        forgotPasswordLink.click();
        BrowserUtils.urlContains("forgot-password",10);
    }
}
