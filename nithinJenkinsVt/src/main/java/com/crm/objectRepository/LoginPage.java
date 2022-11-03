package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaretion
	@FindAll({@FindBy(xpath = "//input[@type='text']"),@FindBy(name = "user_n")})
	//@FindBys({@FindBy(xpath = "//input[@type='text']"),@FindBy(name = "user_name")})
	private WebElement usernametxtEdt;

	@FindBy(name = "user_password")
	private WebElement passwordtxtEdt;


	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getUsernametxtEdt()
	{
		return usernametxtEdt;
	}

	public WebElement getPasswordtxtEdt() {
		return passwordtxtEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * click on submit button
	 */

	public void loginToAppli(String username,String password)
	{
		usernametxtEdt.sendKeys(username);
		passwordtxtEdt.sendKeys(password);
		submitBtn.click();
	}
}
