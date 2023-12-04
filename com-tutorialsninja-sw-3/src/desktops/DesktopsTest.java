package desktops;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
//        1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        1.2 Click on “Show All Desktops”
        WebElement showAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a"));
        showAllDesktops.click();
//        1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown =driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(2); // select by index
//        1.4 Verify the Product will arrange in Descending order.
        WebElement dropDown1 =driver.findElement(By.id("input-sort"));
        Assert.assertTrue(dropDown1.isDisplayed());
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//        2.1 Mouse hover on Desktops Tab. and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        2.2 Click on “Show All Desktops”
        WebElement showAllDesktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a"));
        showAllDesktops.click();
//        2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown =driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByIndex(1); // select by index
//        2.4 Select product “HP LP3065”
        WebElement laptop = driver.findElement(By.xpath("//div[@id='product-category']/div/div/div[4]/div[3]/div/div[2]/div[1]/h4/a"));
        laptop.click();
//        2.5 Verify the Text "HP LP3065"
        String actualResult = driver.findElement(By.xpath("//div[@id='product-product']/div/div/div/div[2]/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "HP LP3065";
        Assert.assertEquals(actualResult,expectedResult);
//        2.6 Select Delivery Date "2022-11-30"
        WebElement deliveryDate = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
        deliveryDate.clear();
        deliveryDate.sendKeys("2023-12-25");
//        2.7.Enter Qty "1” using Select class.
        WebElement quantity = driver.findElement(By.name("quantity"));
        quantity.clear();
        quantity.sendKeys("1");
//        2.8 Click on “Add to Cart” button
        WebElement addCart = driver.findElement(By.id("button-cart"));
        addCart.click();
//        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualResult1 = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText();
        System.out.println(actualResult1);
        Thread.sleep(1000);
        String expectedResult1 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualResult1,expectedResult1);
//        2.10 Click on link “shopping cart” display into success message
        WebElement cart = driver.findElement(By.xpath("//ul[@class='list-inline']/li[4]/a/i"));
        cart.click();
//        2.11 Verify the text "Shopping Cart"
        String actualResult2 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div/div/h1")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actualResult2,expectedResult2);
//        2.12 Verify the Product name "HP LP3065"
        String actualResult3 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a")).getText();
        System.out.println(actualResult3);
        String expectedResult3 = "HP LP3065";
        Assert.assertEquals(actualResult3,expectedResult3);
//        2.13 Verify the Delivery Date "2022-11-30"
        String actualResult4 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/small[1]")).getText();
        System.out.println(actualResult4);
        String expectedResult4 = "Delivery Date:2023-12-25";
        Assert.assertEquals(actualResult4,expectedResult4);
//        2.14 Verify the Model "Product21"
        String actualResult5 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]")).getText();
        System.out.println(actualResult5);
        String expectedResult5 = "Product 21";
        Assert.assertEquals(actualResult5,expectedResult5);
//        2.15 Verify the Total "£74.73"
        String actualResult6 = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]")).getText();
        System.out.println(actualResult6);
        String expectedResult6 = "$122.00";
        Assert.assertEquals(actualResult6,expectedResult6);
    }

    @After
    public void endTest(){
        //closeBrowser();
    }
}
