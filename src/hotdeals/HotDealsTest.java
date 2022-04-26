package hotdeals;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        Thread.sleep(1000);
       mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
       mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        // Verify the given text 'Sale'
        //Validate expected and actual message
        verifyElements("Error message displayed","Sale",By.xpath("//h1[@id='page-title']"));

       mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
       mouseHoverAndClick(By.xpath("//span[contains(text(),'Recommended')]"));
       mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
       // mouseHoverAndClick(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]"));

      // mouseHoverAndClick(By.xpath("//li[8][@class = 'list-type-grid ']/child::a"));

        // Verify that the product arrange alphabetically
        //Validate expected and actual message
       verifyElements("Error message displayed","Name A - Z",By.xpath("//a[contains(text(),'Name A - Z')]"));
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        Thread.sleep(1000);

        mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        // Verify the given text 'Sale'
        //Validate expected and actual message
        verifyElements("Error message displayed","Sale",By.xpath("//h1[@id='page-title']"));

        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.partialLinkText("Price Low - Hi"));

        // Verify that the products' price arrange 'Low to High'
        //Validate expected and actual message
        verifyElements("Error message displayed","Price Low - Hi",By.partialLinkText("Price Low - Hi"));
    }
    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        Thread.sleep(1000);

        mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        // Verify the given text 'Sale'
        //Validate expected and actual message
        verifyElements("Error message displayed","Sale",By.xpath("//h1[@id='page-title']"));

        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.partialLinkText("Rates"));

        // Verify that the product's arrange Rates
        //Validate expected and actual message
        verifyElements("Error message displayed","Rates",By.partialLinkText("Rates"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));

        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name Z - A')]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("Products not arranged","Name Z - A",By.xpath("//span[@class='sort-by-value']"));
    }
    @Test
    public void verifyBestSellersProductsArrangeHighToLow() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));

        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.partialLinkText("Price High - L"));

        // Verify that the products' price arrange High to Low
        //Validate expected and actual message
        verifyElements("Products not arranged","Price High - Low",By.partialLinkText("Price High - L"));
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("error message", "Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"));

        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.partialLinkText("Rates"));

        // Verify that the product's arrange Rates
        //Validate expected and actual message
        verifyElements("Error message displayed", "Rates", By.partialLinkText("Rates"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
