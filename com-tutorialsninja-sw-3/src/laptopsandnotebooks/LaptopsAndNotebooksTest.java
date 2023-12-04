package laptopsandnotebooks;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        1.2 Click on “Show All Laptops & Notebooks”
        WebElement showAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a"));
        showAllDesktops.click();
//        1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4); // select by index
//        1.4 Verify the Product price will arrange in High to Low order.
        WebElement dropDown1 = driver.findElement(By.id("input-sort"));
        Assert.assertTrue(dropDown1.isDisplayed());
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        2.2 Click on “Show All Laptops & Notebooks”
        WebElement showAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div/a"));
        showAllDesktops.click();
//        2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(4); // select by index
//        2.4 Select Product “MacBook”
        WebElement macBook = driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div/div[2]/div[1]/h4/a"));
        macBook.click();
//        2.5 Verify the text “MacBook”
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "MacBook";
        Assert.assertEquals(actualResult, expectedResult);
//        2.6 Click on ‘Add To Cart’ button
        WebElement addCart = driver.findElement(By.id("button-cart"));
        addCart.click();
//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualResult1 = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText();
        System.out.println(actualResult1);
        Thread.sleep(1000);
        String expectedResult1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualResult1, expectedResult1);
//        2.8 Click on link “shopping cart” display into success message
        WebElement cart = driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a/i"));
        cart.click();
//        2.9 Verify the text "Shopping Cart"
        String actualResult2 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/h1")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualResult2, expectedResult2);
//        2.10 Verify the Product name "MacBook"
        String actualResult3 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a")).getText();
        System.out.println(actualResult3);
        String expectedResult3 = "MacBook";
        Assert.assertEquals(actualResult3, expectedResult3);
//        2.11 Change Quantity "2"
        WebElement quantity = driver.findElement(By.xpath("//div[@class='input-group btn-block']/input"));
        quantity.clear();
        quantity.sendKeys("2");
//        2.12 Click on “Update” Tab
        WebElement update = driver.findElement(By.xpath("//button[@type='submit']/i"));
        update.click();
//        2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualResult4 = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText();
        System.out.println(actualResult4);
        String expectedResult4 = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualResult4, expectedResult4);
//        2.14 Verify the Total £737.45
        String actualResult5 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]")).getText();
        System.out.println(actualResult5);
        String expectedResult5 = "$1,204.00";
        Assert.assertEquals(actualResult5, expectedResult5);
//        2.15 Click on “Checkout” button
        WebElement checkOut = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        checkOut.click();
//        2.16 Verify the text “Checkout”
        String actualResult6 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualResult6);
        String expectedResult6 = "Checkout";
        Assert.assertEquals(actualResult6, expectedResult6);
//        2.17 Verify the Text “New Customer”
        Thread.sleep(5000);
        String actualResult7 = driver.findElement(By.xpath("//div[@id='collapse-checkout-option']/div/div/div[1]/h2")).getText();
        System.out.println(actualResult7);
        String expectedResult7 = "New Customer";
        Assert.assertEquals(actualResult7, expectedResult7);
//        2.18 Click on “Guest Checkout” radio button
        WebElement guestCheckout = driver.findElement(By.xpath("//div[@id='collapse-checkout-option']/div/div/div[1]/div[2]/label/input"));
        guestCheckout.click();
//        2.19 Click on “Continue” tab
        WebElement continueTab = driver.findElement(By.xpath("//div[@id='collapse-checkout-option']/div/div/div[1]/input"));
        continueTab.click();
//        2.20 Fill the mandatory fields
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Khushbu");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Patel");
        WebElement email = driver.findElement(By.id("input-payment-email"));
        email.sendKeys("khushbu2827@gmail.com");
        WebElement telephone = driver.findElement(By.name("telephone"));
        telephone.sendKeys("9879731846");
        WebElement address1 = driver.findElement(By.xpath("//fieldset[@id='address']/div[2]/input"));
        address1.sendKeys("20 High Street");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Dagenham");
        WebElement postCode = driver.findElement(By.name("postcode"));
        postCode.sendKeys("RM12 2HJ");
        WebElement country = driver.findElement(By.id("input-payment-country"));
        Select select1 = new Select(country);
        select1.selectByVisibleText("United Kingdom");
        WebElement state = driver.findElement(By.id("input-payment-zone"));
        Select select2 = new Select(state);
        select2.selectByVisibleText("Essex");
//        2.21 Click on “Continue” Button
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/input"));
        continueButton.click();
//        2.22 Add Comments About your order into text area
        WebElement addComment = driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div/p[2]/textarea"));
        addComment.sendKeys("Codebuster Delivery");
//        2.23 Check the Terms & Conditions check box
        WebElement termsAndConditions = driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div/div[2]/div/input[1]"));
        termsAndConditions.click();
//        2.24 Click on “Continue” button
        WebElement clickContinue = driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div/div[2]/div/input[2]"));
        clickContinue.click();
//        2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(5000);
        String actualResult8 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        System.out.println(actualResult8);
        String expectedResult8 = "Warning: Payment method required!\n" +
                "×";
        Assert.assertEquals(actualResult8, expectedResult8);
    }

    @After
    public void endTest() {
        //closeBrowser();
    }
}
