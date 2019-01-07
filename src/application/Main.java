package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Products;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Products> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		     for (int i=1; i<=n; i++) {
		    	 System.out.println("Product #" + i + " data: ");
		    	 System.out.print("Commom, used or imported?(c/u/i) ");
		    	 char ch = sc.next().charAt(0);
		       	 System.out.print("Name: ");
		    	 sc.nextLine();
     	    	 String name = sc.nextLine();
     	    	 System.out.print("Price: ");
     	    	 double price = sc.nextDouble();
     	    	 
     	    	      if(ch == 'c') {
     	    	    	  list.add(new Products(name, price));
     	    	      }
     	    	      else if (ch == 'i') {
     	    	    	  System.out.print("Customs fee: ");
     	    	    	  double customsFee = sc.nextDouble();
     	    	    	  list.add(new ImportedProduct(name, price, customsFee));
     	    	      }
     	    	      else {
     	    	    	  System.out.println("Manufacture date(DD/MM/YYYY) : ");
     	    	    	  Date date = sdf.parse(sc.next());
     	    	    	  list.add(new UsedProduct(name, price, date));
     	    	      }
		  	     
		     }
		     
		     System.out.println();
		     System.out.println("PRICE TAGS: ");
		     for (Products prod : list) {
		    	 System.out.println(prod.priceTag());
		     }
		     
		sc.close();

	}

}