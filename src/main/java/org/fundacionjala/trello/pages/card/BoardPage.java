package org.fundacionjala.trello.pages.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoardPage {
    private WebDriver webDriver;
    private String xpathCard = "//*[@class='list-card-title js-card-name' and contains(text(),'%s')]";

    public BoardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CSS, using = ".list-name-input")
    private WebElement txtNameList;

    @FindBy(how = How.CSS, using = ".mod-list-add-button.js-save-edit")
    private WebElement btnAddList;

    @FindBy(how = How.CSS, using = ".open-card-composer.card-templates-enabled.js-open-card-composer")
    private WebElement btnAddCard;

    @FindBy(how = How.CSS, using = ".js-cancel-edit")
    private WebElement btnExitCard;

    @FindBy(how = How.CSS, using = ".list-card-composer-textarea.js-card-title")
    private WebElement txtNameCard;

    @FindBy(how = How.CSS, using = ".js-add-card")
    private WebElement btnAcceptAddCard;

    @FindBy(how = How.CSS, using = ".js-cancel")
    private WebElement btnCancelAddCard;

    @FindBy(how = How.CSS, using = ".button-link.js-archive-card")
    private WebElement btnArchiveCard;

    @FindBy(how = How.CSS, using = ".button-link.js-delete-card.negate")
    private WebElement btnDeleteCard;

    @FindBy(how = How.CSS, using = ".js-confirm.full.negate")
    private WebElement btnConfirmDeleteCard;

    @FindBy(how = How.CSS, using = ".list-card.js-member-droppable.ui-droppable")
    private WebElement btnEdit;

    @FindBy(how = How.CSS, using = ".primary.wide.js-save-edits")
    private WebElement btnSave;

    @FindBy(how = How.XPATH, using = "//textarea[@class='list-card-edit-title js-edit-card-title']")
    private WebElement txtareaNewCardName;

    public void createList(final String nameList) {
        txtNameList.sendKeys(nameList);
        btnAddList.click();
        btnExitCard.click();
    }

    public void createCard(final String nameCard) {
        btnAddCard.click();
        txtNameCard.sendKeys(nameCard);
        btnAcceptAddCard.click();
        btnCancelAddCard.click();
    }

    public String extractTextToTheCard(final String cardName) {
        String node = String.format(xpathCard, cardName);
        return webDriver.findElement(By.xpath(node)).getText();
    }

    public void deleteCard(final String cardName) {
        String node = String.format(xpathCard, cardName);
         webDriver.findElement(By.xpath(node)).click();
         btnArchiveCard.click();
         btnDeleteCard.click();
         btnConfirmDeleteCard.click();
    }

    public List<WebElement> listOfCards(final String cardName) {
        String node = String.format(xpathCard, cardName);
        return webDriver.findElements(By.xpath(node));
    }

    public void rigthClickSelectCard(final String nameCard) {
        Actions actions = new Actions(webDriver);
        String node = String.format("//span[contains(text(),'%s')]", nameCard);
        WebElement btnEditR =  webDriver.findElement(By.xpath(node));
        actions.contextClick(btnEditR).perform();
    }

    public void editCreatedCard(final String nameCard, final String newNameCard) {
        rigthClickSelectCard(nameCard);
        txtareaNewCardName.sendKeys(newNameCard);
        btnSave.click();
    }

    public void selectCard(final String nameCard) {
        String node = String.format("//span[contains(text(),'%s')]", nameCard);
        WebElement btnSelect = webDriver.findElement(By.xpath(node));
        btnSelect.click();
    }

    public boolean verifySelectedCardNameInTheTitle(final String nameCard) {
        WebElement txtNameSelectedCard = webDriver.findElement(
                By.xpath(String.format("//a[@class='action-card' and contains(text(),'%s')]", nameCard)));
        return txtNameSelectedCard.getText().contains(nameCard);
    }

    public boolean verifyListSelectedCardNameInTheTitle(final String nameList) {
        WebElement txtTitleNameSelectedCard =  webDriver.findElement(
                By.xpath(String.format("//*[@class='js-open-move-from-header' and contains(text(),'%s')]", nameList)));
        return txtTitleNameSelectedCard.getText().contains(nameList);
    }

    public boolean verifyPageTtile(final String nameCard) {
        return webDriver.getTitle().contains(nameCard);
    }

    public boolean verifyCardNameInTheMenuActivity(final String nameCard) {
        WebElement node = webDriver.findElement(By.xpath(String.format(
                "//a[contains(text(),'%s')]", nameCard)));
        return  node.getText().contains(nameCard);

    }
}
