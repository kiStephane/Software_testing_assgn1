package src;
public class Book {
	
	private double basePrice = 0;
	private double vat = 0;
	private double discount = 0;
	private double sellPrice;
	private boolean bestseller = false;
	

	public Book() {
		this.basePrice = 0;
		this.vat = 0;
		this.discount = 0;
		this.bestseller = false;
	}

	public Book(double basePrice, double discount, double vat, boolean bestseller) {
		if(basePrice<0){
			this.basePrice=0.0;
		}else{
			this.basePrice = basePrice;
		}
		if (discount<0){
			this.discount=0;
		}else{
			this.discount = discount;
		}		
		if(vat<0){
			this.vat=0;
		}else{
			this.vat = vat;
		}
		
		this.bestseller = bestseller;
		setSellPrice();
	}
	

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		if(basePrice<0.0){
			System.out.println("Base price should not be negative");
			this.basePrice=0.0;
		}else{		
			this.basePrice = basePrice;
		}		
		setSellPrice();
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		if (vat<0){
			this.vat=0.0;
		}else{
			this.vat = vat;
		}
		setSellPrice();
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		if (discount > 50){
			System.out.println("discount can not be larger than 50 %");
			this.discount = 50;
		}
		else if(discount<0){
			System.out.println("discount can not be negative");
			this.discount = 0;
		}
		else {
			this.discount = discount;
		}
		setSellPrice();
	}
	
	public boolean getBestSeller(){
		return bestseller; 
	}
	
	public void setBestSeller(){
		this.bestseller = true;
		setSellPrice();
	}

	public double getSellPrice() {
		return sellPrice;
	}

	private void setSellPrice() {
		if(basePrice > 0){
			if(bestseller == true){
				sellPrice = basePrice *((100 + (vat - discount* 0.5)) / 100);
			}
			else{
			sellPrice = basePrice * ((100 + (vat - discount)) / 100);
			}
		}
		else
		{
			System.out.println("The base price must be greater than zero"); 
		}
	}

}