package org.fundacionjala.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazaro on 11/12/2019.
 * trello-tests.
 */
public class ConfigVariableHandler {
    private Map<String, String> configVariablesMap;

    public ConfigVariableHandler() {
        configVariablesMap = new HashMap<>();
    }

    public Map getCredentials(final String account) {
        String usernameOwner = Environment.getInstance().getValue(String.format("credentials.%s.username", account));
        String passwordOwner = Environment.getInstance().getValue(String.format("credentials.%s.password", account));
        this.configVariablesMap.put("usernameOwner", usernameOwner);
        this.configVariablesMap.put("passwordOwner", passwordOwner);
        return configVariablesMap;
    }

    public Map getApiToken(final String account) {
        String apiToken = Environment.getInstance().getValue(String.format("credentials.%s.apiToken", account));
        this.configVariablesMap.put("apiToken", apiToken);
        return configVariablesMap;
    }

    public Map getKeyToken(final String account) {
        String keyToken = Environment.getInstance().getValue(String.format("credentials.%s.keyToken", account));
        this.configVariablesMap.put("keyToken", keyToken);
        return configVariablesMap;
    }

    public Map getUrl() {
        String urlConfig = Environment.getInstance().getValue(String.format("url.%s", "trello"));
        this.configVariablesMap.put("url", urlConfig);
        return configVariablesMap;
    }

    public Map getUri() {
        String urlConfig = Environment.getInstance().getValue(String.format("url.%s", "trelloApiUri"));
        this.configVariablesMap.put("uri", urlConfig);
        return configVariablesMap;
    }
}
