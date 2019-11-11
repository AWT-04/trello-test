package org.fundacionjala.trello;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BoardPage {

    public BoardPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}