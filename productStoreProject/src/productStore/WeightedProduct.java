package productStore;

public class WeightedProduct extends Product {
	private double productWeight;
	public WeightedProduct(int productID, String ProductName, String productDescription, double productPrice, double productWeight) {
		super(productID, ProductName, productDescription, productPrice);
		this.productWeight = productWeight;
	}
    
	public double getProductWeight() {
		return productWeight;
	}
	

	@Override
	public double CalculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
