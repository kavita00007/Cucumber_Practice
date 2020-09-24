package com.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageObject {
	
	WebDriver driver;
	private By Product=By.xpath("//div[contains(text(),'Textured Low-Top Lace-Up Casual Shoes')]");
	private By Img=By.xpath("//div[@class='col-6']//div[5]//div[1]//img[1]");
	private By ProductColour=By.xpath("//p[@class='prod-color']");
	private By AddToCart=By.xpath("//span[contains(text(),'ADD TO BAG')]");
	private By AddToCloset=By.xpath("//div[@class='btn-gray']");
	
	public ProductPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickOnProduct() {
		WebDriverWait wait1=new WebDriverWait(driver,20);
		WebElement product=wait1.until(ExpectedConditions.elementToBeClickable(Product));
		product.click();
	}
	
	public void ImgVisibilitycheck() {
		boolean b=driver.findElement(Img).isDisplayed();
		Assert.assertEquals("Product image displayed",true, b);

	}
	
	public void ProductColorcheck()  {
		boolean b=driver.findElement(ProductColour).isDisplayed();
		Assert.assertEquals("Product colour displayed",true, b);

	}
	
	public void AddToClosetButtonCheck() {
		boolean b=driver.findElement(AddToCloset).isDisplayed();
		Assert.assertEquals("Product colour displayed",true, b);
		
	}
	
	public void AddToCartButton() {
		WebElement size=driver.findElement(By.xpath("//div[contains(@class,'circle size-variant-item size-instock')][contains(text(),'8')]"));
		size.click();
		WebDriverWait Wait2 = new WebDriverWait(driver,20);
		WebElement add = Wait2.until(ExpectedConditions.elementToBeClickable(AddToCart));
		add.click();
	}

}
