package ru.bdd.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features"}, glue = {"ru.bdd.automation"},
        plugin = {
                "ru.bdd.automation.utils.AllureReporter",
        }
)
public class CucumberRunner {

}