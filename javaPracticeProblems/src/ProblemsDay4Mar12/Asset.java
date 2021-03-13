package ProblemsDay4Mar12;

public class Asset {
	private int sno;
	private String model;
	private String allotedMonth;
	private int quantity;

	public Asset() {
		super();
	}

	public Asset(int sno, String model, String allotedMonth, int quantity) {
		super();
		this.sno = sno;
		this.model = model;
		this.allotedMonth = allotedMonth;
		this.quantity = quantity;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAllotedMonth() {
		return allotedMonth;
	}

	public void setAllotedMonth(String allotedMonth) {
		this.allotedMonth = allotedMonth;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
