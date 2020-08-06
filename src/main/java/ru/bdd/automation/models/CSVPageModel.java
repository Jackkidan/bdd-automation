package ru.bdd.automation.models;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

public class CSVPageModel implements CSVModel {

    public static HashMap<String, String> modelsMap = ModelsExtractor.getPagesFromCSV();

    @Getter
    @Setter
    private String page;

    CSVPageModel(String pageName) {
        this.page = pageName;
    }
}
