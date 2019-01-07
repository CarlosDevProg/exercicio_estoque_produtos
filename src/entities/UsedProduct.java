package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Products {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufacturedDate;

	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}
	
	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	@Override
	public String priceTag() {
		return getName() + "(used) " +" $ " + String.format("%.2f", getPrice()) + " (Manufacture date: " + sdf.format(manufacturedDate) + ")";
	}
}
