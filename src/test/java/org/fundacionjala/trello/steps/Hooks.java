package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.api.Authentication;
import org.fundacionjala.api.RequestManager;
import org.fundacionjala.core.utils.ConfigVariableHandler;

import java.util.List;

public class Hooks {

    @Before("@cleanBoards")
    public void iSendDeleteAllBoardsByPrefixBefore() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification("owner"),
                "/members/me/boards?filter=open)&key=" + configVariableHandler.getKeyToken("owner")
                        .get("keyToken") + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            System.out.println(configVariableHandler.getKeyToken("owner").get("keyToken") + ".............key");
            RequestManager.delete(Authentication.getRequestSpecification("owner"),
                    "/boards/" + allID.get(i) + "?key=" + configVariableHandler.getKeyToken("owner").get("keyToken")
                            + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
            System.out.println(allName.get(i));
        }

    }

    @Before("@cleanCards")
    public void iSendDeleteAllCardsToByPrefixBefore() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification("owner"),
                "/members/me/cards?filter=open)&key=" + configVariableHandler.getKeyToken("owner")
                        .get("keyToken") + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            System.out.println(configVariableHandler.getKeyToken("owner").get("keyToken") + ".............key");
            RequestManager.delete(Authentication.getRequestSpecification("owner"),
                    "/cards/" + allID.get(i) + "?key=" + configVariableHandler.getKeyToken("owner").get("keyToken")
                            + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
            System.out.println(allName.get(i));
        }

    }

    @After("@cleanBoardsAfter")
    public void iSendDeleteAllBoardsByPrefixAfter() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification("owner"),
                "/members/me/boards?filter=open)&key=" + configVariableHandler.getKeyToken("owner")
                        .get("keyToken") + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            System.out.println(configVariableHandler.getKeyToken("owner").get("keyToken") + ".............key");
            RequestManager.delete(Authentication.getRequestSpecification("owner"),
                    "/boards/" + allID.get(i) + "?key=" + configVariableHandler.getKeyToken("owner").get("keyToken")
                            + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
            System.out.println(allName.get(i));
        }

    }

    @After("@cleanCardsAfter")
    public void iSendDeleteAllCardsToByPrefixAfter() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification("owner"),
                "/members/me/cards?filter=open)&key=" + configVariableHandler.getKeyToken("owner")
                        .get("keyToken") + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            System.out.println(configVariableHandler.getKeyToken("owner").get("keyToken") + ".............key");
            RequestManager.delete(Authentication.getRequestSpecification("owner"),
                    "/cards/" + allID.get(i) + "?key=" + configVariableHandler.getKeyToken("owner").get("keyToken")
                            + "&token=" + configVariableHandler.getApiToken("owner").get("apiToken"));
            System.out.println(allName.get(i));
        }

    }
}
