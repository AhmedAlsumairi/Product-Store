package productStore;

public class DimensionalProduct extends Product {
	private double productWidth;
	private double productLeangth;
	
	
	public DimensionalProduct(int productID, String ProductName, String productDescription, double productPrice,double productWidth, double productLeangth ) {
		super(productID, ProductName, productDescription, productPrice);
		this.productWidth = productWidth;
		this.productLeangth = productLeangth;
	}
    public double getProductWidth() {
    	return this.productWidth;
    }
    
    public double getProductLeangth() {
    	return this.productLeangth;
    }
    
    
	@Override
	public double CalculatePrice() {
		System.out.println("leangth "+ this.productLeangth);
		System.out.println("width " + this.productWidth);
		System.out.println("price " + this.productPrice);
		return this.productLeangth + this.productWidth + productPrice;
	}

}
