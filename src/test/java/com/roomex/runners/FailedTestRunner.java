package com.roomex.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/failed-html-report.html"},
        features = "@target/rerun.txt",
        glue = "com/roomex/step_definitions"
)
public class FailedTestRunner {

}
