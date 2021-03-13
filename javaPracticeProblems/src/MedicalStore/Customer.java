package MedicalStore;

public class Customer {
	private int id;
	private String name;
	private byte age;
	private Medicine medicine;
	public Customer() {
		super();
	}
	public Customer(int id, String name, byte age,Medicine medicine) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.medicine=medicine;
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
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
}
