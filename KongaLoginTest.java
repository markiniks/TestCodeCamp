import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class KongaLoginTest {

    private WebDriver driver;

    @BeforeTest
    public void Start(){

        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

        driver = new ChromeDriver();

    }

    @Test (priority = 0)
    public void OpenUrl() throws InterruptedException {
        //inputting the Url to test
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //Verify that the Url opens Konga.com
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Url");
        else
            //Fail
            System.out.println("Wrong Url");

        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    public void Getpagetitle() throws InterruptedException {
        //Verify the page title
        String expectedTitle = driver.getTitle();
        String actualTitle = "Buy Phones, Fashion, Electronics in Nigeria_Konga Online Shopping | Konga Online Shopping";
        if(actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Title Page");
        else
            //Fail
            System.out.println("incorrect Title");


    }
    @Test (priority = 2)
    public void Openloginpage() throws InterruptedException {
        //Click on Login/signup to Login
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Verify that Login page open successfully
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Pass");
        else
            //Fail
            System.out.println("Fail");
        Thread.sleep(5000);

    }
    @Test (priority = 3)
    public void InputValidEmail() throws InterruptedException {
        //input valid email address to login
        driver.findElement(By.id("username")).sendKeys("input valid email");
        System.out.println("Valid Email Entered");
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void InputValidPassword() throws InterruptedException {
        //input valid password to login
        driver.findElement(By.id("password")).sendKeys("input valid password");
        System.out.println("Valid Password Entered");
        Thread.sleep(3000);
    }
    @Test (priority = 5)
    public void Login() throws InterruptedException {
        //click on login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        System.out.println("Successfully Logged in");
        Thread.sleep(5000);

    }
    @Test (priority = 6)
    public void Logout() throws InterruptedException {
        //click on my Account to logout
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(1000);
        //click on logout
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        System.out.println("Successfully Logged Out");
        Thread.sleep(10000);

    }
    @Test (priority = 7)
    public void invalidEmail() throws InterruptedException {
        //open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //clear email field
        driver.findElement(By.id("username")).clear();
        Thread.sleep(5000);
        //clear password field
        driver.findElement(By.id("password")).clear();
        Thread.sleep(5000);
        //input invalid email address
        driver.findElement(By.id("username")).sendKeys("input invalid email");
        Thread.sleep(5000);
        //input valid password
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        // Verify that invalid Email address can not login
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("The username or password you have entered is incorrect. Please try again.");
        else
            //Fail
            System.out.println("Login Successfully");
        //close unsuccessful login page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/a/span")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 8)
    public void InvalidPassword() throws InterruptedException {
        //open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //clear email field
        driver.findElement(By.id("username")).clear();
        Thread.sleep(5000);
        //clear password field
        driver.findElement(By.id("password")).clear();
        //input valid email address
        driver.findElement(By.id("username")).sendKeys(" input valid email");
        Thread.sleep(5000);
        //input invalid password
        driver.findElement(By.id("password")).sendKeys("passw");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        // Verify that invalid Email address can not login
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("The password must be at least 6 characters");
        else
            //Fail
            System.out.println("Login Successfully");
        //close unsuccessful login page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/a/span")).click();
        Thread.sleep(5000);

    }

    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }


}

