package PrivateSchool;

public class Student {
	private int id;
	private String name;
	private byte standard;
	private int phone;
	private double totalFees;
	private double feesSubmitted;
	public Student() {
		super();
	}
	public Student(int id, String name, byte standard, int phone, double totalFees, double feesSubmitted) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.phone = phone;
		this.totalFees = totalFees;
		this.feesSubmitted = feesSubmitted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getStandard() {
		return standard;
	}
	public void setStandard(byte standard) {
		this.standard = standard;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public double getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}
	public double getFeesSubmitted() {
		return feesSubmitted;
	}
	public void setFeesSubmitted(double feesSubmitted) {
		this.feesSubmitted = feesSubmitted;
	}
	

}
