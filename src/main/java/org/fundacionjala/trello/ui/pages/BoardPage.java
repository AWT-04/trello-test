package org.fundacionjala.trello.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BoardPage {
    private WebDriver webDriver;

    public BoardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CSS, using =".list-name-input")
    public WebElement txtNameList;

    @FindBy(how = How.CSS, using =".mod-list-add-button.js-save-edit")
    public WebElement btnAddList;

    @FindBy(how = How.CSS, using =".open-card-composer.card-templates-enabled.js-open-card-composer")
    public WebElement btnAddCard;

    @FindBy(how = How.CSS, using =".js-cancel-edit")
    public WebElement btnExitCard;

    @FindBy(how = How.CSS, using =".list-card-composer-textarea.js-card-title")
    public WebElement txtNameCard;

    @FindBy(how = How.CSS, using =".js-add-card")
    public WebElement btnAcceptAddCard;

    @FindBy(how = How.CSS, using =".js-cancel")
    public WebElement btnCancelAddCard;



    public void createList(final String nameList) {
        txtNameList.sendKeys(nameList);
        btnAddList.click();
        btnExitCard.click();
    }

    public void createCard(final String nameCard){
        btnAddCard.click();
        txtNameCard.sendKeys(nameCard);
        btnAcceptAddCard.click();
        btnCancelAddCard.click();
    }



}
