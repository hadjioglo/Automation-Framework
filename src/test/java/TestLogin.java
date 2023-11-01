import org.example.ui.InvoiceListPage;
import org.example.ui.LoginPage;
import org.example.ui.WebDriverSetup;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestLogin {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = WebDriverSetup.getDriver("chrome");
    }

    @Test
    public void loginAgencyUser() throws InterruptedException {

        driver.get("https://192.168.2.12:8443/#/login");
        LoginPage loginPage = new LoginPage(driver);
        WebDriverSetup.waitForElement("username");

//        login with finance user
        loginPage.enterUsername("hudson.finance@orion.com");
        WebDriverSetup.waitForElement("password");

        loginPage.enterPassword("user");
        WebDriverSetup.waitForElement("view-all-invoices");

        InvoiceListPage invoiceListPage = new InvoiceListPage(driver);
        Assert.assertTrue(invoiceListPage.isInvoiceListDisplayed());

    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.quitDriver();
    }
}
