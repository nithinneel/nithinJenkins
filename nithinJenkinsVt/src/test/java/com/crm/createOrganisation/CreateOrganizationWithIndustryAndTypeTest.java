package com.crm.createOrganisation;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;

@Listeners(com.crm.genericUtilities.ItestListenerImtn.class)
public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{
	@Test(retryAnalyzer = com.crm.genericUtilities.RetryAnalyserImptn.class)
	public void createOrganizationWithIndustryAndTypeTest() 
	{
		//To get random number
		int randNum = jLib.getRandomNumber();

		//Fetch data from excel sheet
		String orgName = eLib.readDataFromExcel("Organisations", 1, 2)+randNum;

		//Fetch industry from excel
		String industryName = eLib.readDataFromExcel("Organisations", 4, 3);

		//Fetch type from excel
		String typeName = eLib.readDataFromExcel("Organisations", 4, 4);

		//click on organization link
		HomePage homepage =new HomePage(driver);
		homepage.getOrganisationsLnk().click();

		//click on create organization icon
		OrganisationPage organisationPage= new OrganisationPage(driver);
		organisationPage.clickOnCreateOrgLkp();

		//enter the organization name with industry and type
		CreateNewOrganisationPage createNewOrganisationPage=new CreateNewOrganisationPage(driver);
		createNewOrganisationPage.enterOrgInfo(orgName);
		createNewOrganisationPage.selectIndustry(industryName);
		createNewOrganisationPage.selectType(typeName);

		//verify whether the organization is created or not
		OrganisationInfoPage organisationInfoPage=new OrganisationInfoPage(driver);
		String presentOrgName=organisationInfoPage.getOgnHeaderTxt().getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(presentOrgName.contains(orgName));

		//Print output is report and console
		Reporter.log("CreateOrganizationWithIndustryAndTypeTest is pass",true);
		softAssert.assertAll();
	}
}
