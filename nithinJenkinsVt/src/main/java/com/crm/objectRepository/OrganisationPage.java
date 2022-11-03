package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	//declaretion
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLkpUpImg;

	//initialization
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLkpUpImg()
	{
		return createOrgLkpUpImg;
	}

	public void clickOnCreateOrgLkp()
	{
		createOrgLkpUpImg.click();
	}
}
