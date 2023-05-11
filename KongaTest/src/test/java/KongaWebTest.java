import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaWebTest {
        //import selenium WebDriver
    private WebDriver driver;
    @BeforeTest
    public void Beginning() throws InterruptedException {
        //locate where chromedriver is
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //1. Open a Chrome browser
        driver= new ChromeDriver();
        //2. Input Konga URL ("https://www.konga.com/")
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //4. Click Login
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
    }
    @Test (priority = 0)
    public void PositiveLogin() throws InterruptedException {
        //5. To input email address on the email address/phone number field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("awwal@mailinator.com");
        //6. To input password on the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("awwal3");
        //7. Click on Login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
    }
    @Test (priority = 1)
    public void Addtocart() throws InterruptedException {
        //8. Click on computers and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //9. Click on Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(1000);
        //10. Click on Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(20000);
        //11. Add an item to Cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(17000);
    }

    @Test (priority = 2)
    public void Clickcartbutton() throws InterruptedException {
        //12. Click My Cart button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(10000);
        //13. Click the checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(20000);
    }
    @Test (priority = 3)
    public void Selectaddress() throws InterruptedException {
        //14. Click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(10000);
        //15. Click on Add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(10000);
        //16. Select Address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(10000);
        //17. Click use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(10000);

    }
    @Test (priority = 4)
    public void Paynow() throws InterruptedException {
        //18. Click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(10000);
        //19. Click on Continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 5)
    public void Selectpaymentmethod() throws InterruptedException {
       // Select payment method on iFrame
        //20.  Locate the iFrame
        WebElement theframe = driver.findElement(By.tagName("iframe"));
        //21.  Switch focus to iFrame
        driver.switchTo().frame("kpg-frame-component");
        //22.  Locate the card button
        WebElement Clickcardbutton = driver.findElement(By.className("Card"));
        //23.  Click the card button
        Clickcardbutton.click();
        Thread.sleep(5000);
        // Enter card details
        //24.  Locate the card number field and enter an invalid card number
        WebElement Cardnumberinputfield = driver.findElement(By.id("card-number"));
        Cardnumberinputfield.sendKeys("5399123412341234");
        //25.  Locate the date field and enter an invalid date
        WebElement Dateinputfield = driver.findElement(By.id("expiry"));
        Dateinputfield.sendKeys("0723");
        //26.  Locate CVV field and input invalid CVV
        WebElement CVVinputfield = driver.findElement(By.id("cvv"));
        CVVinputfield.sendKeys("231");
        //27.  Click on pay now
        WebElement Paynowbutton = driver.findElement(By.id("validateCardForm"));
        Paynowbutton.click();
        Thread.sleep(6000);
        //28.  Locate and print out the error message-Invalid card number
        WebElement errormessage = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(errormessage.getText());
        Thread.sleep(6000);
        //29.  Close the iFrame that displays the input card model
        WebElement closeiFrame = driver.findElement(By.className("data-card__close"));
        closeiFrame.click();
        //30.  Switch out of iFrame
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser(){
        //31.  Close the browser
        driver.quit();
    }
}
