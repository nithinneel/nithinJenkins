package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilities.WebDriverUtility;
/**
 * 
 * @author SanjayBabu
 *
 */
public class HomePage extends WebDriverUtility{
	//WebDriver driver;
	//declaretion
	@FindBy(linkText = "Organizations")
	private WebElement organisationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLnk;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;

	//initialization
	public HomePage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getOrganisationsLnk() {
		return organisationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getAdministratorLnk() {
		return administratorLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	
	public void logout(WebDriver driver)
	{                     
		mouseOverAnElement(driver, administratorLnk);
		signoutLnk.click();
	}
}
