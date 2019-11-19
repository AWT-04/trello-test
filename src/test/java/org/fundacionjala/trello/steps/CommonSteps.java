package org.fundacionjala.trello.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.utils.Environment;
import org.fundacionjala.trello.pages.common.Login;

public class CommonSteps {
    private static final Environment ENVIRONMENT = Environment.getInstance();
    private Login login;

    public CommonSteps() {
        login = new Login();
    }

    @Given("I log in with the user {string}")
    public void iLogInWithUser(final String key) {
        String userName = ENVIRONMENT.getValue(String.format("credentials.%s.username", key));
        String password = ENVIRONMENT.getValue(String.format("credentials.%s.password", key));
        login.login(userName, password);
    }
}
