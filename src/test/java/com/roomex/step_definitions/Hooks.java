package com.roomex.step_definitions;

import com.roomex.utilities.BrowserUtils;
import com.roomex.utilities.ConfigurationReader;
import com.roomex.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@ui")
    public void setUp() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }




}
