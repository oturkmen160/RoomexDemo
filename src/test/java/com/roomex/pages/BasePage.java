package com.roomex.pages;

import com.roomex.utilities.BrowserUtils;
import com.roomex.utilities.Driver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }




    public boolean isMsgDisplayed(WebElement element){


        /*
        try {
            BrowserUtils.waitForVisibility(element,5);
        }catch (TimeoutException e){
            return false;
        }

         */


        //check if it's displayed
        if(element.isDisplayed()){
            //and has content
            if(!element.getAttribute("textContent").isEmpty()){
                return true;
            }
        }

        return false;
    }
}
