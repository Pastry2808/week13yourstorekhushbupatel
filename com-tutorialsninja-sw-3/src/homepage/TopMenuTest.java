package homepage;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    /*
    create class "TopMenuTest"
    1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    string
    1.2 This method should click on the menu whatever name is passed as parameter.
    */
    public void selectMenu(String menu){
        WebElement elements = driver.findElement(By.xpath(menu));
        elements.click();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
//        1.1 Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
          selectMenu("//ul[@class='nav navbar-nav']/li[1]/div/a");
//        1.3 Verify the text ‘Desktops’
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Desktops";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
//        2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("//ul[@class='nav navbar-nav']/li[2]/div/a");
//        2.3 Verify the text ‘Laptops & Notebooks’
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Laptops & Notebooks";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
//        3.1 Mouse hover on “Components” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
        actions.moveToElement(desktops).click().build().perform();
//        3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("//ul[@class='nav navbar-nav']/li[3]/div/a");
//        3.3 Verify the text ‘Components’
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Components";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
