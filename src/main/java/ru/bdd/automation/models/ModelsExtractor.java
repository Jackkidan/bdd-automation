package ru.bdd.automation.models;

import javafx.util.Pair;
import ru.bdd.automation.exceptions.CSVModelException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class ModelsExtractor {

    private ModelsExtractor() {
    }

    static HashMap<String, CSVElementModel> getElementsFromCSV() {
        HashMap<String, CSVElementModel> modelsMap = new HashMap<>();
        File csvFile = new File("elementsRepository.csv");
        assert csvFile.exists();
        try {
            Scanner csvScanner = new Scanner(csvFile);
            StringBuilder stringBuilder = new StringBuilder();
            CSVElementModel csvElementModel;
            while (csvScanner.hasNextLine()) {
                String data = csvScanner.nextLine().trim();
                if (!data.endsWith(";;") && !data.isEmpty()) {
                    csvElementModel = (CSVElementModel) stringToCSVModel(data);
                    modelsMap.put(stringBuilder
                            .append(Objects.requireNonNull(csvElementModel).getPageName())
                            .append(" - ")
                            .append(csvElementModel.getFieldName())
                            .toString(), csvElementModel);
                    stringBuilder.setLength(0);
                }
            }
            csvScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return modelsMap;
    }

    static HashMap<String, String> getPagesFromCSV() {
        HashMap<String, String> modelsMap = new HashMap<>();
        File csvFile = new File("elementsRepository.csv");
        assert csvFile.exists();
        try {
            Scanner csvScanner = new Scanner(csvFile);
            while (csvScanner.hasNextLine()) {
                String data = csvScanner.nextLine().trim();
                if (!data.endsWith(";;") && !data.isEmpty() && getPreModelPair(data) != null) {
                    modelsMap.put(Objects.requireNonNull(getPreModelPair(data)).getKey(),
                            Objects.requireNonNull(getPreModelPair(data)).getValue());
                }
            }
            csvScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return modelsMap;
    }

    private static CSVModel stringToCSVModel(String str) {
        CSVModel newModel = null;
        String[] preModel = str.split(";");

        if (preModel.length == 5) {
            if (preModel[0].startsWith("+")) {
                CSVPageModel.modelsMap.put(preModel[0].replace("+", ""), preModel[1]);
                newModel = new CSVElementModel(preModel[0].replace("+", ""), preModel[1], preModel[2], preModel[3], preModel[4]);
            } else {
                newModel = new CSVElementModel(preModel[0], preModel[1], preModel[2], preModel[3], preModel[4]);
            }
        }
        return newModel;
    }

    private static Pair<String, String> getPreModelPair(String data) {
        Pair<String, String> pair = null;
        try {
            String[] preModel = data.split(";");
            if (preModel.length == 5 && preModel[0].startsWith("+")) {
                pair = new Pair<>(preModel[0].replace("+", ""), preModel[1]);
            }
        } catch (NullPointerException e) {
            throw new CSVModelException(e);
        }
        return pair;
    }
}
