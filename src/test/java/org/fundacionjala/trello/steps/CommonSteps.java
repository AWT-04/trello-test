package org.fundacionjala.trello.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.utils.Environment;
import org.fundacionjala.trello.pages.DashboardPage;
import org.fundacionjala.trello.pages.common.LoginPage;

public class CommonSteps {
    private static final Environment ENVIRONMENT = Environment.getInstance();
    private LoginPage loginPage;

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    private DashboardPage dashboardPage;

    public CommonSteps() {
        loginPage = new LoginPage();
    }
    @Given("I log in with the user {string}")
    public void iLogInWithUser(final String key) {
        String userName = ENVIRONMENT.getValue(String.format("credentials.%s.username", key));
        String password = ENVIRONMENT.getValue(String.format("credentials.%s.password", key));
        dashboardPage = loginPage.login(userName, password);
    }
}
