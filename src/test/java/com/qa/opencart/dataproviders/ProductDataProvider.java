package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {
	
	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {

		return new Object[][] {
				{ new Product("Macbook", "MacBook Pro", 4) },
				{ new Product("imac", "iMac", 3) }, 
				{ new Product("samsung", "Samsung SyncMaster 941BW", 1) },
				{ new Product("samsung", "Samsung Galaxy Tab 10.1", 7) },

		};

	}
	@DataProvider(name="productDataWithImage")
	public Object[][] getProductImagesTestData() {
		
			return new Object[][] {
				{"Macbook","MacBook Pro",4},
				{"imac","iMac",3},
				{"samsung","Samsung SyncMaster 941BW",1},
				{"samsung","Samsung Galaxy Tab 10.1",7},
					
				};
			
			
		}
	@DataProvider(name="productDataWithName")
	public Object[][] getProductData() {
		
			return new Object[][] {
				{"Macbook","MacBook Pro"},
				{"imac","iMac"},
				{"samsung","Samsung SyncMaster 941BW"},
				{"samsung","Samsung Galaxy Tab 10.1"},
					
				};
			
			
		}
	@DataProvider(name="productDataWithSearchKey")
	public Object[][] getProductSearchKeyData() {
		
		return new Object[][] {
			{"Macbook"},
			{"imac"},
			{"samsung"}
				
			};
		
	}
	//******HomeWork**********
	
	@DataProvider(name="productDataInfo")
	public Object[][] getProductDataInfo(){
		return new Object[][] {
		
			{new Product("Apple","In Stock","MacBook Pro","$2,000.00","Product 18")}
			
		};
		
		
	}
		

}
