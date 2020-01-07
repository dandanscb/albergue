package domain;

public class Room {
	
	private int number;
	private double dimension;
	private DailyRate dailyRate;
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getDimension() {
		return dimension;
	}
	
	public void setDimension(double dimension) {
		this.dimension = dimension;
	} 

	public DailyRate getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(DailyRate dailyRate) {
		this.dailyRate = dailyRate;
	}

	public String toString( ) {
		String resultado = "Room number...: " + this.number + "\n" +
	                                    "Room dimension (m2)...: " + this.dimension + "\n";
		return resultado;
	}

}
