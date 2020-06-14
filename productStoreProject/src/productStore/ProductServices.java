package productStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServices {
	public List<Product> listProducts = new ArrayList<Product>();
	
	
	public List<Product> loadFromFile() {
		listProducts = loadProducts();
		return listProducts;
	}

	public void addProduct(Product product) throws FileNotFoundException, IOException {
		System.out.println(product.getProductID());
		System.out.println(product.getClass().getSimpleName());
		listProducts.add(product);
	}

	public void showPrducts () {
		  for(Product ele:listProducts) { 
			  System.out.println("**************** product("+ listProducts.indexOf(ele) +")************************* ");
			  System.out.println("Porduct ID : " + ele.getProductID());
			  System.out.println("Porduct Name : " + ele.getProductName());
			  System.out.println("Porduct Description : " + ele.getProductDescription());
			  System.out.println("Porduct Price : " + ele.getProductPrice());
			  if (ele.getClass().getSimpleName().equals("DimensionalProduct") ) {
				  DimensionalProduct p = (DimensionalProduct)ele;
				  System.out.println("Porduct Leangth : " + p.getProductLeangth());  
				  System.out.println("Porduct width : " + p.getProductLeangth()); 
			  }
			  if(ele.getClass().getSimpleName().equals("WeightedProduct") ) {
				  WeightedProduct w = (WeightedProduct)ele;
				  System.out.println("Porduct Weight : " + w.getProductWeight());
			  }
			  }
	}
	
	public List<Product> loadProducts() {
		 List<Product> listProducts2 = new ArrayList<Product>();

		try {
			File file = new File("test.txt"); // creates a new file instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
			String line;
			int count=0;
			while ((line = br.readLine()) != null) {
				sb.append(line); // appends line to string buffer
				sb.append("\n"); // line feed
				 if(count > 0) {
					 String[] split = line.split(",");
					    if (split.length > 6) {
							Product p = new DimensionalProduct(Integer.parseInt(split[0].trim()), split[1].trim(),
									                           split[2].trim(), Double.parseDouble(split[3].trim()), 
									                           Double.parseDouble(split[4].trim()), 
									                           Double.parseDouble(split[5].trim()));
							listProducts2.add(p);
					    }
					    if (split.length <= 6) {
					    	Product w = new WeightedProduct(Integer.parseInt(split[0].trim()), split[1].trim(),
					    			                        split[2].trim(),Double.parseDouble(split[3].trim()),
					    			                        		Double.parseDouble(split[4].trim()));
							listProducts2.add(w);
					    }	
				 }
				 count++;	
			}
			fr.close(); // closes the stream and release the resources
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listProducts2;
	}

	// Delete Product base on Product ID
	public int deleteProduct(int productID) {
		int flag = 0;
		int index = 0;
		for(Product ele:listProducts) { 
			  if(ele.getProductID() == productID) {
				  index = listProducts.indexOf(ele);
				  flag++;
			    }
			  }
		    delete(index);
		return flag;
	}
	private void delete (int i) {
		listProducts.remove(i);
	}

	public int editProduct(int productID) {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		for(Product ele:listProducts) { 
			  if(ele.getProductID() == productID) {
				  System.out.println("Enter (1) : Edite Product Name , "
				  		                 + "(2) : Edite Product Description  "+"\n +"
				  		             + " \" (3) : Edite Product Price : " );
				  int c = scanner.nextInt();
				  scanner.nextLine();
				  switch (c) {
				case 1: System.out.println("Edite Product Name : ");
				        ele.setProductName(scanner.nextLine());
				        break;
				case 2: System.out.println("Edite Product Description : ");
		                ele.setProductDescription(scanner.nextLine());
		                break;
				
				case 3: System.out.println("Edite Product Price : ");				         
				        ele.setProductPrice(scanner.nextDouble()); 
				        break;
				default:
					break;
				}
				  flag++;
			    }
			  }
		return flag;
	}

	public double calTotalPrice() {
		return 0;
	}
	

	public int SaveData() throws IOException {
		File file = new File("test.txt");
		FileOutputStream fo = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(fo,false);
		
        
		      pw.print("ID,");
		      pw.print(" NAME,");
		      pw.print(" DESCRIPTION,");
		      pw.print(" PRICE,");
		      pw.print(" TYPE,");
		      pw.print("\n");
		
		for (Product elem : listProducts) {
			if (elem.getClass().getSimpleName().equals("WeightedProduct")) {
				System.out.println("wer -" + elem.getClass().getSimpleName());
				pw.print(elem.getProductID() + ", ");
				pw.print(elem.getProductName() + ", ");
				pw.print(elem.getProductDescription() + ", ");
				pw.print(elem.getProductPrice() + ", ");
				WeightedProduct w = (WeightedProduct) elem;
				pw.print(w.getProductWeight() + ", ");
				pw.print("W");
				pw.print("\n");
			}
			if (elem.getClass().getSimpleName().equals("DimensionalProduct")) {
				pw.print(elem.getProductID() + ", ");
		     	pw.print(elem.getProductName() + ", ");
		    	pw.print(elem.getProductDescription() + ", ");
			    pw.print(elem.getProductPrice() + ", ");
		    	DimensionalProduct d = (DimensionalProduct) elem;
		    	pw.print(d.getProductLeangth() + ", ");
		    	pw.print(d.getProductWidth() + ", ");
		    	pw.print("D");
		    	pw.print("\n");
			}
         
		}
		pw.close();
		fo.close();
		return 0;
	}
	
	
	public double calculatePrice ( ) {
		double totlaPrice = 0;
		if (listProducts != null ) {
			for(Product ele:listProducts) { 
				totlaPrice += ele.getProductPrice();
			}
		}
		return totlaPrice;
	}

}
