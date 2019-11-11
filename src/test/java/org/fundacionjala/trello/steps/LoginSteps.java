package org.fundacionjala.trello.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.ui.pages.BoardPage;
import org.fundacionjala.trello.ui.pages.DashboardPage;
import org.fundacionjala.trello.ui.pages.LoginPage;

import java.util.Map;

public class LoginSteps {
    @Given("I login as user:")
    public void iLoginAsUser(final Map<String, String> user) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login(user.get("name"), user.get("password"));
        BoardPage boardPage = dashboardPage.createBoard("my board");
        boardPage.createList("To Do");
        boardPage.createCard("Selenium tasks");
        boardPage.createCard("Java tasks");
        boardPage.createCard("Python tasks");
    }
}