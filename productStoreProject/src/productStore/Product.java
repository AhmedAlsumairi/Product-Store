package productStore;

public abstract class Product {
	private int productID;
	private String productName;
	private String productDescription;
	protected double productPrice;
	public Product(int productID, String ProductName, String productDescription , double productPrice ) {
		this.productID = productID;
		this.productName = ProductName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}
	
	public int getProductID() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription( ) {
		return this.productDescription;
	}
	public void setProductDescription(String ProductDescription) {
		this.productDescription = ProductDescription;
	}
	public double getProductPrice() {
		return this.productPrice;
	}
	public void setProductPrice(double productPrice) {
		 this.productPrice = productPrice ;
	}
	
	public abstract double CalculatePrice();

	

}
