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
    String name = "AWT-" + LocalTime.now().toString();
    String boardId;
    public static String URLBOARD = "";

    @Before ("@createBoard")
    public void createBoard(){
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        Map<String, String> body = new HashMap<String, String>();
        body.put("name", name);
        Response response = RequestManager.Trellopost(Authentication.getRequestSpecification("owner"),
                "https://api.trello.com/1/boards", body);
        boardId = response.jsonPath().getString("id");
        URLBOARD = response.jsonPath().getString("shortUrl");
        System.out.println("Board created succesfully..." + body);
    }

    @After ("@deleteBoard")
    public void deleteBoard(){
        RequestManager.delete(Authentication.getRequestSpecification("owner"),  String.format("https://api.trello.com/1/boards/%s", boardId));
        System.out.println("Board deleted sucessfully...");
    }
}