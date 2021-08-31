package com.example.justai;

import java.io.*;

public final class ApiConfig {
    private static final String FILE_NAME = "config.txt";
    private static final String FILE_PATH = ""; // заполнить путь до директории
    private static ApiConfig apiConfig;
    private String accessToken;
    private String extraText;
    private String apiVersion;

    private ApiConfig() {
        parseConfigurationFile();
    }

    private void parseConfigurationFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String propertyValue = line.replaceAll(line.substring(0, line.indexOf('"') + 1), "");
                propertyValue = propertyValue.replaceAll(propertyValue.substring(propertyValue.indexOf('"')), "");
                populateProperties(line, propertyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void populateProperties(final String line, final String propertyValue) {
        if ("".equals(propertyValue)) {
            throw new RuntimeException("Bad config");
        }

        if (line.contains("access_token")) {
            accessToken = propertyValue;
        }
        if (line.contains("extra_text")) {
            extraText = propertyValue;
        }
        if (line.contains("api_version")) {
            apiVersion = propertyValue;
        }
    }

    public static ApiConfig getInstance() {
        if (apiConfig == null) {
            apiConfig = new ApiConfig();
        }
        return apiConfig;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getExtraText() {
        return extraText;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}
