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
public class CreateNewOrganisationPage extends WebDriverUtility{
	//declaretion
	@FindBy(name = "accountname")
	private WebElement organisationTextEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	//initialization
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganisationTextEdt() {
		return organisationTextEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public void setOrganisationTextEdt(WebElement organisationTextEdt) {
		this.organisationTextEdt = organisationTextEdt;
	}

	/**
	 * 
	 * @param enter organisationName 
	 * select the industry
	 * select the type
	 */
	public void enterOrgName(String orgname)
	{
		organisationTextEdt.sendKeys(orgname);
		saveBtn.click();
	}

	public void enterOrgInfo(String organisationName)
	{
		organisationTextEdt.sendKeys(organisationName);
	}
	public void selectIndustry(String industry)
	{
		selectDropDown(industryDropDown, industry);
	}
	public void selectType(String type)
	{
		selectDropDown(typeDropDown, type);
		saveBtn.click();
	}
}
