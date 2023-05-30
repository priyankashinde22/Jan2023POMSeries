package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTest extends BaseTest {
	
	
//	@DataProvider
//	public Object[][] incorrectLoginTestData() {
//		return new Object[][] {
//			{"auto123@gmail.com","123456"},
//			{"test@@gamilcom","123132"},
//			{"auto","test"},
//			{"@!#@!!","@&#@"},
//		
//		};
//		
//	}
	@DataProvider(name="loginExcelData")
	public Object[][]incorrectLoginTestData(){
		Object incorrectData[][]=ExcelUtil.getTestData(AppConstants.LOGIN_SHEET_NAME);
		return incorrectData;
		
	}
	
	
	@Test(dataProvider ="loginExcelData")
	public void LoginWithWrongCredentialsTest(String userName ,String password) {
		
		Assert.assertTrue(loginPage.doLoginWithWrongCredentials(userName, password));
		
	}

}
