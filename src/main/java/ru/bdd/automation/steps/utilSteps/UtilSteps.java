package ru.bdd.automation.steps.utilSteps;

public class UtilSteps {

    public void waitStep(String value) {
        try {
            Thread.sleep(Integer.parseInt(value) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
