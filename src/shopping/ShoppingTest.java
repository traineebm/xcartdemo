package shopping;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyFOrOllieTheAppControlledRobot() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("Bestsellers message not displayed","Bestsellers",By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]"));

        //1.4
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));


        //1.5
        Thread.sleep(1000);
        mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/h5[1]/a[1]"));
        mouseHoverAndClick(By.xpath("//div[contains(@class,'items-list items-list-products category-products')]//span[contains(text(),'Add to cart')]"));

        //1.6
        // Verify the message 'Product has been added to your cart'
        //Validate expected and actual message
        verifyElements("Error message displayed","Product has been added to your cart",By.xpath("//li[contains(text(),'Product has been added to your cart')]"));

        // 1.7
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));

        //1.8
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[5]/div[4]"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //1.9
        //Verify the given text 'Your shopping cart 1 item'
        verifyElements("Error message displayed","Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"));

        //1.10
        //Verify the given text 'Subtotal:$299.00'
        verifyElements("Error message displayed","Subtotal: $299.00",By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
        //1.11
        //Verify the given text 'Total:$309.73'
        verifyElements("Error message displayed","Total: $309",By.xpath("//span[contains(text(),'309')]"));

        //1.12
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[5]/button[1]"));

        //1.13
        // Verify the text "Log in to your account"
        verifyElements("Error message displayed","Log in to your account",By.xpath("//h3[contains(text(),'Log in to your account')]"));

        //1.14
        // Finding the email field element
        sendTextToElement(By.id("email"),"alpha789@gmail.com");

        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));

        //1.16
        //Verify the given text 'Secure Checkout'
        verifyElements("Error message displayed","Secure Checkout",By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]"));

        // Finding the firstname field element and all mandatory elements
        sendTextToElement(By.name("shippingAddress[firstname]"),"Alpa");
        sendTextToElement(By.name("shippingAddress[lastname]"),"Popat");
        sendTextToElement(By.name("shippingAddress[street]"),"11 Grant Road");
        sendTextToElement(By.name("shippingAddress[city]"),"London");
        sendTextToElement(By.name("shippingAddress[country_code]"),"United Kingdom");
        sendTextToElement(By.name("shippingAddress[custom_state]"),"UK");
        sendTextToElement(By.name("shippingAddress[zipcode]"),"WD24 4DX");
        sendTextToElement(By.id("email"),"alpha789@gmail.com");

        //1.18
        clickOnElement(By.id("create_profile"));

        //1.19
        sendTextToElement(By.id("password"),"Asdfg10");

        //1.20
        //Selecting the local shipping delivery option by clicking on radio button
        clickOnElement(By.xpath("//input[@id='method128']"));

        //1.21
        //Selecting payment method 'COD'
        clickOnElement(By.xpath("//input[@id='pmethod6']"));

        //1.22
        //Verify the given text '$299.00'
        verifyElements("Error message displayed","$299.00",By.xpath("//span[@class='price']/descendant::span[2]"));

        //1.23
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));

        //1.24
        // verify the text 'Thank you for your order'
        verifyElements("Error message displayed","Thank you for your order",By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        mouseHover(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));

        // Verify the given text 'Bestsellers'
        //Validate expected and actual message
        verifyElements("Bestsellers message not displayed","Bestsellers",By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]"));

        //1.4
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));

        //1.5
        Thread.sleep(500);
        mouseHoverAndClick(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[1]/a[1]/img[1]"));
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[2]/div[4]/div[1]/button[1]"));

        //1.6
        verifyElements("Error message displayed","Product has been added to your cart",By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //1.7
        clickOnElement(By.xpath("//a[@class='close']"));
        // 1.8
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));

        // 1.9 Verify the text “Your shopping cart - 1 item”
        verifyElements("Error message displayed","Your shopping cart - 1 item",By.xpath("Your shopping cart - 1 item"));
        //1.10
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //1.11 Verify the text “Are you sure you want to clear your cart ?”on alert
        String actualMessage = getTextFromAlert();
        Assert.assertEquals("Error message displayed", "Are you sure you want to clear your cart?", actualMessage);
        //1.12
        Thread.sleep(500);
        acceptAlert();
        //1.13
        Thread.sleep(2000);
        verifyElements("Error message displayed","Item(s) deleted from your cart",By.xpath("li[contains(text(),'Item(s) deleted from your cart')]"));
        //1.14
        clickOnElement(By.cssSelector(".close"));
        //1.15
        verifyElements("Error message displayed","Your cart is empty",By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
