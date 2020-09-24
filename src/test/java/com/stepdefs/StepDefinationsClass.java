package com.stepdefs;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.HomePageObject;
import com.pageobjects.ProductPageObject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationsClass {
	
	WebDriver driver;
	String App_Url="https://www.Ajio.com";
	
	HomePageObject home=new HomePageObject(driver);
	ProductPageObject product=new ProductPageObject(driver);

	
	@Before
    public void setUp(Scenario sc){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        
    }
    
	

	@Given("User navigated to application url")
		public void user_navigated_to_application_url() {
			driver.get(App_Url);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			WebDriverWait framewait=new WebDriverWait(driver,15);
			WebElement alert=driver.findElement(By.className("ic-close-quickview"));
			alert.click();
			
			//home.validatePageTitleMatch("AJIO");
			home.CheckingAjioLogo();
			home.LoginSigninLink();
		}

     @When("User search for {string}")
		public void user_search_for(String string) {
			home.SearchingForProduct("shoes");
			home.ClickToSearch();
		    
		}
	@When("Result display for shoes")
		public void result_display_for_shoes() {
			home.validatePageTitleMatch("Footwear");
			product.ClickOnProduct();

	        Set<String> handles = driver.getWindowHandles(); 
	        Iterator<String> it = handles.iterator(); 
	        String original = it.next();
	        String prodDescp = it.next();
            driver.switchTo().window(prodDescp);
	
		    
		}
	@When("User select item from list and new tab gets open with item description")
		public void user_select_item_from_list_and_new_tab_gets_open_with_item_description() {
			
			home.validatePageTitleMatch("Buy Black Sports Shoes for Men by Puma Online|Ajio.com ");
			product.AddToClosetButtonCheck();
			product.ImgVisibilitycheck();
			product.ProductColorcheck();
			product.AddToCartButton();
		   
		}
	@Then("User add item to bag to buy")
		public void user_add_item_to_bag_to_buy() {
		    
		}

	    @After
	    public void cleanUp(){
	        try {
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }


}
