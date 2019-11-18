package org.fundacionjala.core.utils;

import java.util.HashMap;

/**
 * @author lazaro on 11/12/2019.
 * trello-tests.
 */
public class ConfigVariableHandler {
    private HashMap<String, String> configVariablesMap;

    public ConfigVariableHandler() {
        configVariablesMap = new HashMap<>();
    }

    public HashMap getCredentials(final String account) {
        String usernameOwner = Environment.getInstance().getValue(String.format("credentials.%s.username", account));
        String passwordOwner = Environment.getInstance().getValue(String.format("credentials.%s.password", account));
        this.configVariablesMap.put("usernameOwner", usernameOwner);
        this.configVariablesMap.put("passwordOwner", passwordOwner);
        return configVariablesMap;
    }

    public HashMap getApiToken(String account){
        String apiToken = Environment.getInstance().getValue(String.format("credentials.%s.apiToken", account));
        this.configVariablesMap.put("apiToken", apiToken);
        return configVariablesMap;
    }

    public HashMap getKeyToken(String account){
        String keyToken = Environment.getInstance().getValue(String.format("credentials.%s.keyToken", account));
        this.configVariablesMap.put("keyToken", keyToken);
        return configVariablesMap;
    }

    public HashMap getUrl() {
        String urlConfig = Environment.getInstance().getValue(String.format("url.%s", "trello"));
        this.configVariablesMap.put("url", urlConfig);
        return configVariablesMap;
    }

    public HashMap getUri() {
        String urlConfig = Environment.getInstance().getValue(String.format("url.%s", "trelloApiUri"));
        this.configVariablesMap.put("uri", urlConfig);
        return configVariablesMap;
    }
}
