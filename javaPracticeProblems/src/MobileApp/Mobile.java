package MobileApp;
public class Mobile {
	// Each Mobile hold the details - Id, Model, Price, NumberofSims, HasCamera
	private int id;
	private String model;
	private double price;
	private byte numberOfSims;
	private boolean hasCamera;
	public Mobile() {
		super();
	}
	
	public Mobile(int id, String model, double price, byte numberOfSims, boolean hasCamera) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.numberOfSims = numberOfSims;
		this.hasCamera = hasCamera;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte getNumberOfSims() {
		return numberOfSims;
	}

	public void setNumberOfSims(byte numberOfSims) {
		this.numberOfSims = numberOfSims;
	}

	public boolean isHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(boolean hasCamera) {
		this.hasCamera = hasCamera;
	}


}
