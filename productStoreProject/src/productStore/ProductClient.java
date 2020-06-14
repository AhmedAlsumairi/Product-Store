package productStore;

import java.io.IOException;
import java.util.Scanner;

public class ProductClient {
	static ProductServices pservice=new ProductServices();
	 
	public static void main(String args[] ) {
		int key=0;
		pservice.loadFromFile();
		do {
			Scanner scan = new Scanner(System.in);
		    System.out.println("\n **************  ENTER OPERATION NO *******************"
		    		+ "\n (1) :- Show Products       (2) :- Add Product"
		    		+" \n (3) :- Delete Product      (4) :- Edit Product"
		    		+" \n (5) :- Calculate Price     (6) :- Save to File"
		    		+" \n (7) :- Exite ");
		    key = scan.nextInt();
			
			switch (key) {
			case 1: 
				    pservice.showPrducts();
			        break;
			case 2: 
				    addPrduct();
	                break;
			case 3:	
				    System.out.println("Enter Product No");
				    pservice.deleteProduct(scan.nextInt());
				    break;
			case 4:	
				    System.out.println("Enter Product No to Edite");
			        pservice.editProduct(scan.nextInt());
			        break;
			case 5:	
	                double totalPrice = pservice.calculatePrice();
	                System.out.println("Total Price : " + totalPrice);
	                break;
			case 6:	
				   try {
				    	pservice.SaveData();
			      	} catch (IOException e) {
					e.printStackTrace();
				    }
	                break; 
			case 7:	System.exit(0);
	                break;

			}
			
		}while (key != 7);
	    
		 
		
		 
		/*
		 * List<Product> list = pservice.loadFromFile(); System.out.println("last size"
		 * + list); for(Product p:list) { }
		 */
		
		//pservice.deleteProduct(1);
		//pservice.sow();
		/*
		 * try { pservice.SaveData(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		/*
		 * pservice.editProduct(2);
		 * 
		 * pservice.sow();
		 */
		/*
		 * try { pservice.SaveData(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		/*
		 * addPrduct(); addPrduct();
		 */
	}
	
	
	
	
	static void addPrduct( ) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Product No (integer type): " );
		int pID = Integer.parseInt(scanner.nextLine());
		System.out.println("Product Name : ");
		String pName = scanner.nextLine();
		System.out.println("Product Description : ");
		String pDesc = scanner.nextLine();
		System.out.println("Product Price (double type ) : ");
		Double pPrice = scanner.nextDouble();
		System.out.println("in case of weighted product "
				            + "press 'w' to enter the weight "
			            	+ "- press 'd' to Dimentional product");
		String flag = scanner.next();
		
		if( flag.equals("w")) {
			System.out.println("Product Weighted ( double type ) : ");
			Double Pweight = scanner.nextDouble();
			Product p1 = new WeightedProduct(pID, pName, pDesc, pPrice,Pweight );
			try {
				pservice.addProduct(p1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
		
		if(flag.equals("d")) {
			System.out.println("Product Leangth ( double type ) : ");
			Double pLenght = scanner.nextDouble();
			System.out.println("Product Width (double type ) ");
			Double pWidth = scanner.nextDouble();
			
			Product p = new DimensionalProduct(pID, pName, pDesc, pPrice, pLenght, pWidth); 
			try {
				pservice.addProduct(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}