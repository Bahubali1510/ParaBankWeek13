package TestSuits;

import BrowserFactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Login extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyThatSigningUpPageDisplay() {
//click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
//* Verify the text ‘Signing up is easy!’
        String ActualText = driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText();
        System.out.println(ActualText);
        String ExpectedText = "Signing up is easy!";
        Assert.assertEquals(ActualText, ExpectedText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("customer.firstName")).sendKeys("ALka");
        driver.findElement(By.id("customer.lastName")).sendKeys("Jadeja");
        driver.findElement(By.id("customer.address.street")).sendKeys("India");
        driver.findElement(By.id("customer.address.city")).sendKeys("Vadodara");
        driver.findElement(By.id("customer.address.state")).sendKeys("Gujarat");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123");
        driver.findElement(By.id("customer.username")).sendKeys("Alka1Jadeja");
        driver.findElement(By.id("customer.password")).sendKeys("abc123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("abc123");
        driver.findElement(By.xpath("//form[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
//* Verify the text 'Your account was created successfully. You are now logged in.’
        String ActualText = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        System.out.println(ActualText);
        String ExpectedText = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(ActualText, ExpectedText);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


//* Enter valid username
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("AlkaJadeja");
//* Enter valid password
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("abc123");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//* Verify the ‘Accounts Overview’ text is display
        String ActualText = driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText();
        System.out.println(ActualText);
        String ExpectedText = "Accounts Overview";
        Assert.assertEquals(ActualText, ExpectedText);
    }

    @Test
    public void verifyTheErrorMessage() {


//* Enter invalid username
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("AlkJadeja");
//* Enter invalid password
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("bc123");
//* Click on Login button
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//* Verify the error message ‘The username and password could not be verified.’
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //* Enter valid username
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[1]/input")).sendKeys("AlkaJadeja");
//* Enter valid password
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("abc123");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
//* Click on ‘Log Out’ link
        driver.findElement(By.xpath("//div[@id='leftPanel']/ul/li[8]/a")).click();
//* Verify the text ‘Customer Login’
        String ActualText = driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText();
        System.out.println(ActualText);
        String ExpectedText = "Customer Login";
        Assert.assertEquals(ActualText, ExpectedText);
    }
}