package com.crm.createOrganisation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;


@Listeners(com.crm.genericUtilities.ListnerImplemplementation.class)
public class ToCreateOrganisationTest extends BaseClass{
	//@Test(retryAnalyzer = com.crm.genericUtilities.RetryAnalysisImplement.class)
	//@Test(priority = 1, invocationCount = 1, retryAnalyzer = com.crm.genericUtilities.RetryAnalysisImplement.class)
	@Test    
	public void createOrganisationTest(){

		//To get random number
		
		int randNum = jLib.getRandomNumber();

		//Fetching data from excelSheet
		String orgName = eLib.readDataFromExcel("Organisations", 1,2)+randNum;

		//click on organization link
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationsLnk().click();
		//Assert.fail();

		//click on create organization icon
		OrganisationPage organisationPage=new OrganisationPage(driver);
		organisationPage.clickOnCreateOrgLkp();

		//enter the organization name and click on save button
		CreateNewOrganisationPage createNewOrganisationPage=new CreateNewOrganisationPage(driver);
		createNewOrganisationPage.enterOrgName(orgName);

		//verify whether the organization is created or not
		OrganisationInfoPage organisationInfoPage = new OrganisationInfoPage(driver);
		String presentOrgName = organisationInfoPage.getOgnHeaderTxt().getText();
		Assert.assertTrue(presentOrgName.contains(orgName));

		//Print output is report and console
		Reporter.log("createOrganisationTest is pass",true);
	}
}