package domain;

public class DailyRate {
	
	private double price;
	
	public DailyRate(double price) {
		 this.price = price;
	}

	public double getValor() {
		return price;
	}

	public void setValor(double price) {
		this.price = price;
	}	
}
