package ru.bdd.automation.steps.utilSteps;

import cucumber.api.java.en.When;

public class ScenarioUtilSteps {
    UtilSteps utilSteps = new UtilSteps();

    @When("^выполнено ожидание на \"(.*)\" (?:секунд|секунду|секунды)")
    public void scenarioWaitStep(String value) {
        utilSteps.waitStep(value);
    }


}
