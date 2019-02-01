package PageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends AbstractedPage{
    private Logger log = Logger.getLogger(GmailLoginPage.class);

    private static final String URL = "https://www.google.com/gmail/about/new/";

    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    @FindBy(css = "input#identifierId.whsOnd.zHQkBf")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    public GmailLoginPage open() {
        driver.get(URL);
        return new GmailLoginPage(driver);
    }

    public GmailLoginPage pressSigninButton() {
        signInButton.click();
        return new GmailLoginPage(driver);
    }

    public GmailLoginPage fillEmailIInput(String query) {
        emailInput.sendKeys(query);
        return new GmailLoginPage(driver);
    }

    public GmailPasswordPage pressNextButton() {
        nextButton.click();
        return new GmailPasswordPage(driver);

    }

}
