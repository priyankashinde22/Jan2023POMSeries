package com.qa.opencart.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.Product;
import com.qa.opencart.utils.AppConstants;

public class ProductPageInfoTest extends BaseTest{
	
	
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	@Test(dataProvider = "productDataInfo", dataProviderClass=ProductDataProvider.class)
	public void productInfoTest(Product product) {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> productInfoMap = productInfoPage.getProductInfo(); //haspmap does not maintain order.it stores as per hacode
		System.out.println(productInfoMap); 
		//--------HashMap--------not maintain order
		//Brand=Apple, Availability=In Stock, extaxprice=$2,000.00, Product Code=Product 18,
		//productname=MacBook Pro, Reward Points=800, productprice=$2,000.00}
		
		//---Linked HashMAp-----maintain the order 
		//{Brand=Apple, Product Code=Product 18, Reward Points=800, Availability=In Stock, 
		//productprice=$2,000.00, extaxprice=$2,000.00, productname=MacBook Pro}
		
		//====TreeMap==== sort data capital then small letter the numeric
		
		//{Availability=In Stock, Brand=Apple, Product Code=Product 18, Reward Points=800,
		//extaxprice=$2,000.00, productname=MacBook Pro, productprice=$2,000.00}
		
		//single assertation use hard one
		/*Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		Assert.assertEquals(productInfoMap.get("productname"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("productprice"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");*/
//		
//		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple"); //softassert is not static
//		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock");
//		softAssert.assertEquals(productInfoMap.get("productname"), "MacBook Pro");
//		softAssert.assertEquals(productInfoMap.get("productprice"), "$2,000.00");
//		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
//		softAssert.assertAll();
		
		//********HomeWork********
		
		
		softAssert.assertEquals(productInfoMap.get("Brand"),product.getBrand());
		softAssert.assertEquals(productInfoMap.get("Availability"), product.getAvailability());
		softAssert.assertEquals(productInfoMap.get("productname"), product.getProductName());
		softAssert.assertEquals(productInfoMap.get("productprice"), product.getProductprice());
		softAssert.assertEquals(productInfoMap.get("Product Code"), product.getProductcode());
		softAssert.assertAll();
		
		
		
		//when to use softassert use for multiple assertion or number of assertaton in one test
//		
//		String successMsg = productInfoPage.addToCart();
//		System.out.println(successMsg);
//		Assert.assertTrue(successMsg.contains("MacBook Pro"));
//	
	}
	
	@Test
	public void addToCartTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
	
		String successMsg = productInfoPage.addToCart();
		System.out.println(successMsg);
		Assert.assertTrue(successMsg.contains("MacBook Pro"));
		
		
	}
	
//	@Test
//	public void addToCartTest() {
//		
//		Assert.assertTrue(productInfoPage.addToCart());
//	}
//	

}
