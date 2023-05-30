package com.qa.opencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private Map<String, String> productInfoMap;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][position()=1]/li");
	private By productPriceData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][position()=2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By successCartMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderName() {
		return eleUtil.doGetElementText(productHeader);
	}

	public int getProductImagesCount() {
		return eleUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
	}

	public Map<String, String> getProductInfo() {
		//productInfoMap = new HashMap<String, String>();
		//productInfoMap = new LinkedHashMap<String, String>(); //maintainig oredr
		productInfoMap = new TreeMap<String, String>(); //sorting map the data capital, small letter and numeric
		getProductMetaData();
		getProductPriceData();
		productInfoMap.put("productname", getProductHeaderName());
		return productInfoMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		

		for (WebElement e : metaList) {
			String metaText = e.getText();
			String metaInfo[] = metaText.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);

		}

	}

	private void getProductPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String priceValue = priceList.get(0).getText();// $2000.00
		String exTaxprice = priceList.get(1).getText();
		String exTaxpriceValue = exTaxprice.split(":")[1].trim();// $2000.00
		productInfoMap.put("productprice", priceValue);
		productInfoMap.put("extaxprice", exTaxpriceValue);

	}
	
	
	public String addToCart() {
		eleUtil.doSendKeys(quantity, "1");
		eleUtil.doClick(addToCartBtn);
		eleUtil.waitForElementVisible(successCartMsg, AppConstants.LONG_DEFAULT_WAIT);
		
		return eleUtil.doGetElementText(successCartMsg);
		
	}
//	public boolean addToCart() {
//		
//		eleUtil.doSendKeys(quantity, "1");
//		eleUtil.doClick(addToCartBtn);
//		eleUtil.waitForElementVisible(successCartMsg, AppConstants.MEDIUM_DEFAULT_WAIT);
//		String successMsg= eleUtil.doGetElementText(successCartMsg);
//		if(successMsg.contains("MacBook Pro")) {
//			
//			return true;
//		}
//		return false;
//		
//	}
	
	
	

}
