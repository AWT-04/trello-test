package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.api.Authentication;
import org.fundacionjala.api.RequestManager;
import org.fundacionjala.core.driver.DriverManager;
import org.fundacionjala.core.utils.ConfigVariableHandler;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    public static String name = "AWT-" + LocalTime.now().toString();
    String boardId;

    @Before ("@createBoard")
    public void createBoard(){
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();
        Map<String, String> body = new HashMap<String, String>();
        body.put("name", name);
        Response response = RequestManager.Trellopost(Authentication.getRequestSpecification("owner"),
                "https://api.trello.com/1/boards", body);
        boardId = response.jsonPath().getString("id");
        System.out.println("Board created succesfully..." + body);
    }

    @After ("@deleteBoard")
    public void deleteBoard(){
        RequestManager.delete(Authentication.getRequestSpecification("owner"),  String.format("https://api.trello.com/1/boards/%s", boardId));
        System.out.println("Board deleted sucessfully...");
        DriverManager.getInstance().getDriver().close();
    }
}