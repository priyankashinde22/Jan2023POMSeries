package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Login Page Design")
@Story("US 101: design login page for open cart app with title, url, forgot pwd links, user is able to login")
public class LoginPageTest extends BaseTest {

	@Severity(SeverityLevel.MINOR)
	@Description("checking login page title test...")
	@Feature("title test")
	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	@Severity(SeverityLevel.NORMAL)
	@Description("checking login page url test...")
	@Feature("url test")
	@Test
	public void getLoginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	@Severity(SeverityLevel.CRITICAL)
	@Description("checking forgotpassword link test...")
	@Feature("forgotpassword test")
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	// p
	@Severity(SeverityLevel.MINOR)
	@Description("checking searchtextbox exist test...")
	@Feature("searchtextbox test")
	@Test
	public void SearchTextboxExistTest() {
		Assert.assertTrue(loginPage.isSearchTextboxExist());
	}

	// p
	@Severity(SeverityLevel.MINOR)
	@Description("checking new customer header exist test...")
	@Feature("new customer header test")
	@Test
	public void headerNewCustomerExistTest() {
		Assert.assertTrue(loginPage.isheaderNewCustomerExist());
	}

	// p
	@Severity(SeverityLevel.MINOR)
	@Description("checking returning customer header exist test...")
	@Feature("returning customer header test")
	@Test
	public void headerReturningCustomerExistTest() {
		Assert.assertTrue(loginPage.isheaderReturningCustomerExist());
	}
	
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("checking user is able to login with correct username /password test...")
	@Feature("login test")
	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
		Assert.assertTrue(accPage.getAccPageTitle().equals(AppConstants.ACCOUNT_PAGE_TITLE_VALUE));
	}


	
}
