package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.api.Authentication;
import org.fundacionjala.api.RequestManager;
import org.fundacionjala.api.ScenarioContext;
import org.fundacionjala.core.utils.Environment;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class HooksCards {
    private static String name = "AWT-" + LocalTime.now().toString();
    private ScenarioContext context;

    public HooksCards(final ScenarioContext context) {
        this.context = context;
    }

    @Before("@createBoard")
    public void createBoard() {
        Map<String, String> body = new HashMap<String, String>();
        body.put("name", name);
        Response response = RequestManager.trellopost(Authentication.getRequestSpecification("owner"),
                Environment.getInstance().getValue("url.trelloApiUri") + "boards", body);
        context.setContext("board", response);
    }

    @After("@deleteBoard")
    public void deleteBoard() {
        RequestManager.delete(Authentication.getRequestSpecification("owner"),
                String.format(Environment.getInstance().getValue("url.trelloApiUri") + "boards/%s",
                        context.getContext("board").jsonPath().getString("id")));
    }
}
