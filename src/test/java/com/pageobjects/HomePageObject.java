package com.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageObject {

	
	WebDriver driver;
	private By AjioLogo=By.xpath("//div[@class='logo-float']//a//img");
	private By Searchbox=By.xpath("//input[@placeholder='Search AJIO']");
	private By SearchButton=By.xpath("//span[@class='ic-search']");
	private By LogIn_SignIn=By.xpath("//span[@class='login-form login-modal']");
	
	public HomePageObject(WebDriver driver)  {
		this.driver=driver;
	}
	
	
	public void CheckingAjioLogo()  {
		boolean b = driver.findElement(AjioLogo).isDisplayed();
		Assert.assertEquals("We are on home page",true, b);
	}
	
	public void SearchingForProduct(String s)  {
		WebDriverWait Wait = new WebDriverWait(driver,20);
		WebElement searchbox = Wait.until(ExpectedConditions.elementToBeClickable(Searchbox));
		searchbox.sendKeys(s);
	}
	
	public void ClickToSearch() {
		boolean b = driver.findElement(SearchButton).isDisplayed();
		Assert.assertEquals("CLick to search product",true, b);
		driver.findElement(SearchButton).click();
	}
	
	public void LoginSigninLink()  {
		boolean b = driver.findElement(LogIn_SignIn).isDisplayed();
		Assert.assertEquals("Login and Signin Link",true, b);
	}
	
	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		Boolean b = wait1.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
	}
}
