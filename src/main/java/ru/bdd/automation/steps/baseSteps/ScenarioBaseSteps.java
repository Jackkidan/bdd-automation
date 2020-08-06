package ru.bdd.automation.steps.baseSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import ru.bdd.automation.core.AbstractPage;

import java.util.List;
import java.util.Map;

public class ScenarioBaseSteps {
    BaseSteps baseSteps = new BaseSteps();

    @When("^загружена страница \"(.*)\"$")
    public void stepLoadPage(String page) {
        AbstractPage.setCurentPage(page);
        baseSteps.pageShouldBeLoaded(page);
    }

    @When("^поле \"(.*)\" заполняется значением \"(.*)\"$")
    public void stepFillField(String fieldName, String value) {
        baseSteps.fillField(fieldName, value);
    }

    @When("^поля заполняются значениями:$")
    public void stepFillFields(DataTable arg) {
        List<Map<String, String>> tableList = arg.asMaps(String.class, String.class);
        tableList.forEach(tableRow -> stepFillField(tableRow.get("Поле"), tableRow.get("Значение")));
    }

    @When("^выполнено нажатие на \"(.*)\"$")
    public void stepClickField(String fieldName) {
        baseSteps.clickField(fieldName);
    }

    @When("^очищено поле \"(.*)\"$")
    public void stepClearField(String fieldName) {
        baseSteps.clearField(fieldName);
    }

    @When("^поле \"(.*)\" стало \"(.*)\"")
    public void stepWaitVisabilityCondition(String fieldName, String condition) throws NoSuchMethodException {
        switch (condition.toLowerCase()) {
            case "видимо":
                baseSteps.waitForVisible(fieldName);
                break;
            case "невидимо":
                baseSteps.waitForInvisible(fieldName);
                break;
            default:
                throw new NoSuchMethodException();
        }
    }

    @When("^значение поля \"(.*)\" равно \"(.*)\"$")
    public void stepCheckFieldValue(String fieldName, String expectedValue) {
        baseSteps.checkValue(fieldName, expectedValue);
    }

    @When("^значения полей:$")
    public void stepCheckFieldValues(DataTable arg) {
        List<Map<String, String>> tableList = arg.asMaps(String.class, String.class);
        tableList.forEach(tableRow -> stepCheckFieldValue(tableRow.get("Поле"), tableRow.get("Значение")));
    }

    @When("^из выпадающего списка \"(.*)\" выбран пункт \"(.*)\"")
    public void stepSelectInput(String fieldName, String value) {
    //TODO
    }

}
