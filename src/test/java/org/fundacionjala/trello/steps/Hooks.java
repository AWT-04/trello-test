package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.trello.api.Authentication;

import java.util.List;

public class Hooks {
    private final String access = "owner";

    @After("@cleanTeams")
    public void iSendDeleteAllTeamsByPrefixBefore() {
        final String prefix = "test";
        Response response = RequestManager.get(Authentication.getRequestSpecification(access),
                "/members/me/organizations?fields=all)");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allID.size(); i++) {
            String name = RequestManager.get(Authentication.getRequestSpecification(access),
                    "/organizations/" + allID.get(i)).jsonPath().getString("name");
            if (name.contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(access),
                        "/organizations/" + allID.get(i));
            }
        }
    }

    @Before("@cleanBoards")
    public void iSendDeleteAllBoardsByPrefixBefore() {
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(access),
                "/members/me/boards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(access),
                        "/boards/" + allID.get(i));
            }
        }
    }

    @Before("@cleanCards")
    public void iSendDeleteAllCardsToByPrefixBefore() {
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(access),
                "/members/me/cards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(access),
                        "/cards/" + allID.get(i));
            }
        }
    }

    @After("@cleanBoardsAfter")
    public void iSendDeleteAllBoardsByPrefixAfter() {
        final String prefix = "Fernando";
        Response response = RequestManager.get(Authentication.getRequestSpecification(access),
                "/members/me/boards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix)) {
                RequestManager.delete(Authentication.getRequestSpecification(access),
                        "/boards/" + allID.get(i));
            }
        }
    }

    @After("@cleanCardsAfter")
    public void iSendDeleteAllCardsToByPrefixAfter() {
        final String prefix = " ";
        Response response = RequestManager.get(Authentication.getRequestSpecification(access),
                "/members/me/cards?filter=open)");
        List<String> allName = response.jsonPath().getList("name");
        List<Integer> allID = response.jsonPath().getList("id");
        for (int i = 0; i < allName.size(); i++) {
            if (allName.get(i).contains(prefix.toLowerCase())) {
                RequestManager.delete(Authentication.getRequestSpecification(access),
                        "/cards/" + allID.get(i));
            }
        }
    }
}
