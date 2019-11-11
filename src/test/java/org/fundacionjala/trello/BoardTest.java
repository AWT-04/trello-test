package org.fundacionjala.trello;

import org.fundacionjala.core.utils.Environment;
import org.fundacionjala.trello.pages.BoardPage;
import org.fundacionjala.trello.pages.DashboardPage;
import org.fundacionjala.trello.pages.common.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTest {
    private DashboardPage dashboardPage;
    private BoardPage boardPage;
    private static final String ACCOUNT = "owner";
    private static final Environment ENVIRONMENT = Environment.getInstance();


    @BeforeMethod
    public void setUpEnvironment() {
        String userName = ENVIRONMENT.getValue(String.format("credentials.%s.username", ACCOUNT));
        String password = ENVIRONMENT.getValue(String.format("credentials.%s.password", ACCOUNT));
        dashboardPage = new LoginPage().login(userName, password);
    }

    @Test
    public void testLogin() { }
}
