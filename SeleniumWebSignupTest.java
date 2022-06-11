import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test (priority = 0)
    public void openurl() throws InterruptedException {
        //input the right url
        driver.get("https://selenium-blog.herokuapp.com/");
        Thread.sleep(5000);
        //test1 verify that user put the right url
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        driver.manage().window().maximize();
    }
    @Test (priority = 1)
    public void clicksignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //test2 verify that when click Signup it opens signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Sign Up page");
         else
             //fail
             System.out.println("Wrong Sign up page");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void positivesignup() throws InterruptedException {

        driver.findElement(By.id("user_username")).sendKeys("mark22");
        driver.findElement(By.id("user_email")).sendKeys("testsignup22@qa.team");
        driver.findElement(By.id("user_password")).sendKeys("abcd1234");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        //test3 verify that user will successful with valid username,email and password.
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.println("Sign up successful");
        else
            //fail
            System.out.println("Sign Up Fail");

    }

    @Test (priority = 3)
    public void clickuser1() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
        //test4 verify that list of content is present in user1
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = (driver.getCurrentUrl());
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct page");
        else
            //fail
            System.out.println("wrong page");
    }

    @Test (priority = 4)
    public void clickxpath() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);
        //test5 verify that learn Xpath will open the article contents
        String expectedUrl = "https://selenium-blog.herokuapp.com/articles/59";
        String actualUrl = (driver.getCurrentUrl());
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct page");
        else
            //fail
            System.out.println("wrong page");
    }
    @Test(priority = 5)
    public void signoutsuccessfully() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //test6 verify that user sign out will direct to Home page
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = (driver.getCurrentUrl());
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Logged out successful");
        else
            //fail
            System.out.println("failed logged out");
    }

    @Test (priority = 6)
     public void invalidusername() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //input invalid username
        Thread.sleep(5000);
        //test7 verify that invalid username can not sign up successfully
        driver.findElement(By.id("user_username")).sendKeys("ma");
        driver.findElement(By.id("user_email")).sendKeys("testsignup11@qa.team");
        driver.findElement(By.id("user_password")).sendKeys("abcd1234");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

     @Test (priority = 7)
     public void emptysignupfield() throws InterruptedException {
         driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
         Thread.sleep(5000);
         //test8 verify that empty sign up fields can not sign up successfully
         driver.findElement(By.id("user_username")).sendKeys(" ");
         driver.findElement(By.id("user_email")).sendKeys(" ");
         driver.findElement(By.id("user_password")).sendKeys(" ");
         driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
         Thread.sleep(5000);

      }
      @Test (priority = 8)
      public void invalidemailsignup() throws InterruptedException {
          driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
          Thread.sleep(5000);
          //test9 verify that invalid email can not sign up successfully
          driver.findElement(By.id("user_username")).sendKeys("mark20");
          driver.findElement(By.id("user_email")).sendKeys("testsignup11");
          driver.findElement(By.id("user_password")).sendKeys("abcd1234");
          driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
      }
    @Test (priority = 9)
    public void tooshortpassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //test10 verify that less than or equal to one character password can not sign up successfully
        driver.findElement(By.id("user_username")).sendKeys("mark20");
        driver.findElement(By.id("user_email")).sendKeys("testsignup20@qa.team");
        driver.findElement(By.id("user_password")).sendKeys("a");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
      }

    @AfterTest
    public void quitpage() {

        driver.quit();
    }

}

