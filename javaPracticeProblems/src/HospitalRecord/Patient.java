package HospitalRecord;

public class Patient {
	// Patient: name, numberOfDaysAdmitted, illnessOccured, billAmount,
	// doctorTreated
	private String name;
	private short numberOfDaysAdmitted;
	private String illnessOccured;
	private double billAmount;
	private String doctorTreated;

	public Patient() {
		super();
	}

	public Patient(String name, short numberOfDaysAdmitted, String illnessOccured, double billAmount,
			String doctorTreated) {
		super();
		this.name = name;
		this.numberOfDaysAdmitted = numberOfDaysAdmitted;
		this.illnessOccured = illnessOccured;
		this.billAmount = billAmount;
		this.doctorTreated = doctorTreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getNumberOfDaysAdmitted() {
		return numberOfDaysAdmitted;
	}

	public void setNumberOfDaysAdmitted(short numberOfDaysAdmitted) {
		this.numberOfDaysAdmitted = numberOfDaysAdmitted;
	}

	public String getIllnessOccured() {
		return illnessOccured;
	}

	public void setIllnessOccured(String illnessOccured) {
		this.illnessOccured = illnessOccured;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getDoctorTreated() {
		return doctorTreated;
	}

	public void setDoctorTreated(String doctorTreated) {
		this.doctorTreated = doctorTreated;
	}

}
