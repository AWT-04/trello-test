package org.fundacionjala.trello.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.fundacionjala.trello.ui.pages.BoardPage;
import org.fundacionjala.trello.ui.pages.DashboardPage;
import org.fundacionjala.trello.ui.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
    private WebDriver webDriver;
    private static final int IMPLICIT_TIME = 15;
    public LoginSteps() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        webDriver.get("https://trello.com/login");
    }

    @Given("I login as user:")
    public void iLoginAsUser(final Map<String, String> user) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.login(user.get("name"), user.get("password"));
        BoardPage boardPage = dashboardPage.createBoard("my board");

        boardPage.createCard("Selenium tasks");
        boardPage.createCard("Java tasks");
        boardPage.createCard("Python tasks");
    }

    @Then("I should see {string} in the list of cards")
    public void iShouldSeeInTheListOfCards(String cardName) {
        BoardPage boardPage = new BoardPage(webDriver);
        String XPath = String.format("//*[@class='list-card-title js-card-name' and contains(text(),'%s')]", cardName);
//        (new WebDriverWait(base.driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tc_menu_header.tc_menu_header_projects")));
        Assert.assertEquals(webDriver.findElement(By.xpath(XPath)).getText(), cardName);

    }

    @When("I add a list with the name {string}")
    public void iAddAListWithTheName(String listName) {
        BoardPage boardPage = new BoardPage(webDriver);
        boardPage.createList(listName);
    }

    @And("I create the following cards:")
    public void iCreateTheFollowingCards(final DataTable cards) {
        BoardPage boardPage = new BoardPage(webDriver);
        for (int i = 0; i < cards.height(); i++) {
            boardPage.createCard(cards.cell(i, 1).toString());
        }
    }
}