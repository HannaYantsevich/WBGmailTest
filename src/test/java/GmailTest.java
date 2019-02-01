import PageFactory.GmailLoginPage;
import PageFactory.GmailMainPage;
import PageFactory.GmailPasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    private WebDriver driver;

    @BeforeClass(description = ("Start browser"))

    public void startBrowser() {
        // System.setProperty("webdriver.chrome.driver",
        // "/Users/hanna_yantsevich/eclipse-workspace/Gmail/WebDriver/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void GmailTest() throws InterruptedException {

        GmailLoginPage gmailloginpage = new GmailLoginPage(driver);
        gmailloginpage.open().pressSigninButton().fillEmailIInput("HannaTest34@gmail.com");

        GmailPasswordPage gmailpasswordpage = gmailloginpage.pressNextButton();
        gmailpasswordpage.fillGmailPasswordInput("PasswordPassword");

        Thread.sleep(1000);
        GmailMainPage gmailmainpage = gmailpasswordpage.pressNextButton().pressComposeButton();
        gmailmainpage.recipentInput().subjectInput().bodyInput().saveAndCloseButton();
        //gmailmainpage.createNewEmailAndSaveItInDrafts();
        Thread.sleep(1000);
        gmailmainpage.draftButton().clickOnDraftEmail().sendButton();
        gmailmainpage.sentButton();
        gmailmainpage.draftsButton().noDraftsButton();
        gmailmainpage.imageButton().signOutButton();

    }

    @AfterClass(description = "Close browser")

    public void kill() {
        driver.quit();
    }

}
