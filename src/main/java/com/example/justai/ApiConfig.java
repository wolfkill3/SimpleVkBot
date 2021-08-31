package com.example.justai;

import java.io.*;

public final class ApiConfig {
    private static final String FILE_NAME = "config.txt";
    private static final String FILE_PATH = ""; // заполнить путь до директории
    private static ApiConfig apiConfig;
    private String accessToken;
    private String extraText;
    private String apiVersion;
    private Integer serverPort;

    private ApiConfig() {
        parseConfigurationFile();
    }

    private void parseConfigurationFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String propertyValue = line.replaceAll(line.substring(0, line.indexOf('"') + 1), "");
                propertyValue = propertyValue.replaceAll(propertyValue.substring(propertyValue.indexOf('"')), "");
                populateProperties(line.replaceAll(line.substring(line.indexOf("=")), ""), propertyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void populateProperties(final String property, final String propertyValue) {
        if ("".equals(propertyValue)) {
            throw new RuntimeException("Bad config");
        }

        switch (property) {
            case "access_token" -> accessToken = propertyValue;
            case "extra_text" -> extraText = propertyValue;
            case "api_version" -> apiVersion = propertyValue;
            case "server_port" -> {
                try {
                    serverPort = Integer.parseInt(propertyValue);
                } catch (Exception e) {
                    serverPort = 8088;
                }
            }
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

    public Integer getServerPort() {
        return serverPort;
    }
}
