package org.fundacionjala.trello;

import org.fundacionjala.core.utils.Environment;
import org.fundacionjala.trello.pages.common.LoginPage;
import org.testng.annotations.Test;

public class BoardTest {
    private static final String ACCOUNT = "owner";
    private static final Environment ENVIRONMENT = Environment.getInstance();

    @Test
    public void testLogin() {
        String userName = ENVIRONMENT.getValue(String.format("credentials.%s.username", ACCOUNT));
        String password = ENVIRONMENT.getValue(String.format("credentials.%s.password", ACCOUNT));
        new LoginPage().login(userName, password);
    }
}
