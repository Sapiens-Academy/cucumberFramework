package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = new ChromeDriver();		
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@Given("^A user is on the homepage$")
    public void a_user_is_on_the_homepage() throws Throwable {
		driver.get("https://winstoncastillo.com/robot-selenium/");
    	Assert.assertEquals(driver.getTitle(), "La tienda de Winston Castillo");
    	driver.manage().window().maximize();
    }

    @When("^Login Page is displayed$")
    public void login_page_is_displayed() throws Throwable {
    	Assert.assertEquals(driver.getTitle(), "Account Login");    	
		WebElement newCustomer = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div"))));
		WebElement returningCustomer = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div"))));
    }

    @Then("^New Customer section is displayed$")
    public void new_customer_section_is_displayed() throws Throwable {
    	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h2")).getText(), "New Customer");    	    	    	
    }

    @And("^go to the login page$")
    public void go_to_the_login_page() throws Throwable {
		WebElement optionLink = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"))));
    	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
    	driver.findElement(By.linkText("Login")).click();
    }
    
    @And("^Returning Customer is displayed$")
    public void returning_customer_is_displayed() throws Throwable {
    	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h2")).getText(), "Returning Customer");    	    	    	
    }
    
    @Given("^User login into the application with username \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void user_login_into_the_application_with_username_something_with_password_something(String userEmail, String password) throws Throwable {
		driver.get("https://winstoncastillo.com/robot-selenium/index.php?route=account/login");
    	driver.manage().window().maximize();
    	driver.findElement(By.id("input-email")).sendKeys(userEmail);
    	driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @Then("^Click on Login button$")
    public void click_on_login_button() throws Throwable {
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }

    @And("^Error Message is displayed$")
    public void error_message_is_displayed() throws Throwable {
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"))));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText(), " Warning: No match for E-Mail Address and/or Password.");
    }


}
