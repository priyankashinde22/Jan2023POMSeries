package com.qa.opencart.pojo;

public class Product {
	
	private String searchKey;
	private String productName;
	private int productImages;
	
	private String brand;
	private String availability;
	//private String productname;
	private String productprice;
	private String productcode;
	
	public Product(String Brand,String Availability,String productname,String productprice,String ProdcutCode) {
		this.brand =Brand;
		this.availability=Availability;
		this.productName =productname;
		this.productprice=productprice;
		this.productcode =ProdcutCode;
	}
	

	
	public Product(String searchKey, String productName, int productImages) {
		
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = productImages;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductImages() {
		return productImages;
	}
	public void setProductImages(int productImages) {
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImages
				+ ", brand=" + brand + ", availability=" + availability + ", productprice=" + productprice
				+ ", productcode=" + productcode + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImages
//				+ "]";
//	}
//	


	
}
