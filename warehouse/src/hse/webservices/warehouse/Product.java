package hse.webservices.warehouse;

public class Product {
	 private String name;
	 private double price;
	 private int availableQuantity;
	 
	 public String getName(){ return name; }
	 public double getPrice() {return price; }
	 public int getAvailableQuantity() { return availableQuantity; }
	 
	 public Product(String name, double price, int availableQuantity){
		 this.name = name;
		 this.price = price;
		 this.availableQuantity = availableQuantity;
	 }
}
