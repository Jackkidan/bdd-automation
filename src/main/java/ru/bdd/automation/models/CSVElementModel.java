package ru.bdd.automation.models;

import lombok.Getter;

import java.util.Map;

public class CSVElementModel implements CSVModel {

    @Getter
    private String pageName;
    @Getter
    private String fieldName;
    @Getter
    private String fieldType;
    @Getter
    private String searchType;
    @Getter
    private String locator;

    public static Map<String, CSVElementModel> modelsMap = ModelsExtractor.getElementsFromCSV();

    CSVElementModel(String pageName, String fieldName, String fieldType, String searchType, String locator) {
        this.pageName = pageName;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.searchType = searchType;
        this.locator = locator;
    }

}
