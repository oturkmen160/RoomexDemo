package com.roomex.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "pretty",
                "html:target/cucumber-report/cucumber.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/roomex/step_definitions",
        dryRun = false,
        tags = ""
)
public class CukesRunner {

}
