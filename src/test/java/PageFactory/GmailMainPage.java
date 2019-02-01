package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMainPage extends AbstractedPage {

    @FindBy(css = ".aic .z0 div")
    private WebElement composeButton;

    @FindBy(css = ".oj div textarea")
    private WebElement recipientInput;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement bodyInput;

    @FindBy(xpath = "//td[@class='Hm']/img[@class='Ha']")
    private WebElement saveAndClose;

    @FindBy(xpath = "//a[contains(text(), 'Drafts')]")
    private WebElement draftButton;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@title='Sent']")
    private WebElement sentButton;

    @FindBy(xpath = "//a[contains(text(), 'Drafts')]")
    private WebElement draftsButton;

    @FindBy(xpath = "//tr[@class='TD']/td[@class='TC']")
    private WebElement noDrafts;

    @FindBy(xpath = "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']")
    private WebElement imageButton;

    @FindBy(xpath = "//*[contains(text(), 'Sign out')]")
    private WebElement signOutButton;

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    public GmailMainPage pressComposeButton() {
        waitForElementPresent(composeButton);
        composeButton.click();
        return new GmailMainPage(driver);
    }

    public GmailMainPage recipentInput() {
        waitForElementPresent(recipientInput);
        waitForElementVisible(recipientInput);
        recipientInput.sendKeys(RECEIVER);
        return new GmailMainPage(driver);
    }

    public GmailMainPage subjectInput() {
        waitForElementVisible(subjectInput);
        subjectInput.sendKeys(SUBJECT);
        return this;
    }

    public GmailMainPage bodyInput() {
        waitForElementVisible(bodyInput);
        bodyInput.sendKeys(BODY);
        return this;
    }

    public GmailMainPage saveAndCloseButton() {
        waitForElementVisible(saveAndClose);
        saveAndClose.click();
        return this;
    }

    public GmailMainPage draftButton() {
        waitForElementVisible(draftButton);
        draftButton.click();
        return this;
    }

    public GmailMainPage clickOnDraftEmail() {
        clickOnElementByJS(driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", SUBJECT))));
        return this;

    }


    public GmailMainPage sendButton() {
        sendButton.click();
        return this;
    }

    public GmailMainPage sentButton() {
        sentButton.click();
        return this;
    }

    public GmailMainPage draftsButton() {
        draftsButton.click();
        return this;
    }

    public GmailMainPage noDraftsButton() {
        noDrafts.click();
        return this;

    }

    public GmailMainPage imageButton() {
        imageButton.click();
        return this;
    }

    public void signOutButton() {
        signOutButton.click();
    }


    public GmailMainPage createNewEmailAndSaveItInDrafts() {
        pressComposeButton()

                .recipentInput()
                .subjectInput()
                .bodyInput()
                .saveAndCloseButton();

        return this;
    }

}
