package org.fundacionjala.trello.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
    }

    @After("@cleanTeams")
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}