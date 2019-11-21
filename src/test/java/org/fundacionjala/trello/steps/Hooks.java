package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.api.Authentication;
import org.fundacionjala.api.RequestManager;
import org.fundacionjala.core.utils.ConfigVariableHandler;

import java.util.List;

public class Hooks {
    private final String ACCESS = "owner";

    @After("@cleanTeams")
    public void iSendDeleteAllTeamsByPrefixBefore() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = "test";
        Response response = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                "/members/me/organizations?fields=all)");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allID.size(); i++) {
            String name = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                    "/organizations/" + allID.get(i)).jsonPath().getString("name");
            System.out.println(name.contains(prefix.toLowerCase()));
            if (name.contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(ACCESS),
                        "/organizations/" + allID.get(i));
            }
        }
    }

    @Before("@cleanBoards")
    public void iSendDeleteAllBoardsByPrefixBefore() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                "/members/me/boards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(ACCESS),
                        "/boards/" + allID.get(i));
            }
        }
    }

    @Before("@cleanCards")
    public void iSendDeleteAllCardsToByPrefixBefore() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                "/members/me/cards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(ACCESS),
                        "/cards/" + allID.get(i));
            }
        }
    }

    @After("@cleanBoardsAfter")
    public void iSendDeleteAllBoardsByPrefixAfter() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = "Fernando";
        Response response = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                "/members/me/boards?filter=open)&key=" + configVariableHandler.getKeyToken(ACCESS)
                        .get("keyToken") + "&token=" + configVariableHandler.getApiToken(ACCESS).get("apiToken"));
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix)) {
                RequestManager.delete(Authentication.getRequestSpecification(ACCESS),
                        "/boards/" + allID.get(i));
            }
        }
    }

    @After("@cleanCardsAfter")
    public void iSendDeleteAllCardsToByPrefixAfter() {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(ACCESS),
                "/members/me/cards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(ACCESS),
                        "/cards/" + allID.get(i));
            }
        }
    }
}
