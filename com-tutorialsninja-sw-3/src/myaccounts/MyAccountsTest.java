package myaccounts;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
//       1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option){
        WebElement elements = driver.findElement(By.xpath(option));
        elements.click();
    }
//       1.2 This method should click on the options whatever name is passed as parameter.
//       (Hint: Handle List of Element and Select options)
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
//        1.1 Click on My Account Link.
        WebElement myAccount = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount.click();
//        1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[1]/a");
//        1.3 Verify the text “Register Account”.
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Register Account";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
//        2.1 Click on My Account Link.
        WebElement myAccount = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount.click();
//        2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[2]/a");
//        2.3 Verify the text “Returning Customer”.
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Returning Customer";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
//        3.1 Click on My Account Link.
        WebElement myAccount = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount.click();
//        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[1]/a");
//        3.3 Enter First Name
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Khushbu");
//        3.4 Enter Last Name
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Patel");
//        3.5 Enter Email
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("khushbu280821@gmail.com");
//        3.6 Enter Telephone
        WebElement telephone = driver.findElement(By.name("telephone"));
        telephone.sendKeys("9879731846");
//        3.7 Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Khushbu@2802#");
//        3.8 Enter Password Confirm
        WebElement confirmPassword = driver.findElement(By.name("confirm"));
        confirmPassword.sendKeys("Khushbu@2802#");
//        3.9 Select Subscribe Yes radio button
        WebElement subscribe = driver.findElement(By.xpath("//div[@id='content']/form/fieldset[3]/div/div/label[1]/input"));
        subscribe.click();
//        3.10 Click on Privacy Policy check box
        WebElement privacyPolicy = driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[1]"));
        privacyPolicy.click();
//        3.11 Click on Continue button
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/input[2]"));
        continueButton.click();
//        3.12 Verify the message “Your Account Has Been Created!”
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Your Account Has Been Created!";
        Assert.assertEquals(actualResult,expectedResult);
//        3.13 Click on Continue button
        WebElement continueButton1 = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        continueButton1.click();
//        3.14 Click on My Account Link.
        WebElement myAccount1 = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount1.click();
//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[5]/a");
//        3.16 Verify the text “Account Logout”
        String actualResult1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualResult1);
        String expectedResult1 = "Account Logout";
        Assert.assertEquals(actualResult1,expectedResult1);
//        3.17 Click on Continue button
        WebElement continueButton2 = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        continueButton2.click();
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
//        4.1 Click on My Account Link.
        WebElement myAccount = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount.click();
//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[2]/a");
//        4.3 Enter Email address
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("khushbu280821@gmail.com");
//        4.5 Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Khushbu@2802#");
//        4.6 Click on Login button
        WebElement login = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input"));
        login.click();
//        4.7 Verify text “My Account”
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "My Account";
        Assert.assertEquals(actualResult,expectedResult);
//        4.8 Click on My Account Link.
        WebElement myAccount1 = driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a/span[1]"));
        myAccount1.click();
//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("//ul[@class='list-inline']/li[2]/ul/li[5]/a");
//        4.10 Verify the text “Account Logout”
        String actualResult1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualResult1);
        String expectedResult1 = "Account Logout";
        Assert.assertEquals(actualResult1,expectedResult1);
//        4.11 Click on Continue button
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        continueButton.click();
    }
    @After
    public void endTest(){
        //closeBrowser();
    }
}
