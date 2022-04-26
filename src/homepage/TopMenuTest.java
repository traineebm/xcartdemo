package homepage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        //Find login link element and click on login link
        clickOnElement(By.linkText("Shipping"));

        // Verify the given text 'Shipping'
        //Validate expected and actual message
        verifyElements("Welcome message not matching","Shipping",By.linkText("Shipping"));
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //Find login link element and click on login link
        clickOnElement(By.linkText("New!"));

        // Verify the given text 'New arrivals'
        //Validate expected and actual message
        verifyElements("New arrivals not displayed","New arrivals",By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        //Find login link element and click on login link
        clickOnElement(By.linkText("Coming soon"));

        // Verify the given text 'Coming soon'
        //Validate expected and actual message
        verifyElements("Coming soon message not displayed","Coming soon",By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        //Find login link element and click on login link
        clickOnElement(By.linkText("Contact us"));

        // Verify the given text 'Contact us'
        //Validate expected and actual message
        verifyElements("Error message displayed","Contact us",By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
