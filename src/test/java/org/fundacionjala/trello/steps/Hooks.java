package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.api.Authentication;
import org.fundacionjala.api.RequestManager;
import org.fundacionjala.core.utils.ConfigVariableHandler;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    RequestManager requestManager;
    String name = LocalTime.now().toString();
    String boardId;

    @Before ("@createBoard")
    public void createBoard(){
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        System.out.println("uri =  " + configVariableHandler.getUri().get("uri"));
        System.out.println(" token =  " + configVariableHandler.getApiToken("owner").get("apiToken"));
        System.out.println(" api =  " + configVariableHandler.getKeyToken("owner").get("keyToken"));
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("name", name);
        Response response = RequestManager.post(Authentication.getRequestSpecification("owner"),
                "https://api.trello.com/1/boards", body);
        System.out.println(response.prettyPrint());
        boardId = response.jsonPath().getString("id");

        System.out.println("Board created succesfully...");
    }

    @After ("@deleteBoard")
    public void deleteBoard(){
        RequestManager.delete(Authentication.getRequestSpecification("owner"),  String.format("https://api.trello.com/1/boards/%s", boardId));
        System.out.println("Board deleted sucessfully...");
    }
}