package EmployeeApp;

public class Employee {
	/* EmpId 
    EmpName 
    DeptName [ Computers / Arts / Physics ]
    Experience - Should be greater than 0
    Designation - Should accept only HOD, Assistant Professor, Professor, Instructor
	*/
	private int EmpId;
	private String EmpName;
	private String DeptName;
	private byte Experience;
	private String Designation;
	public Employee() {
		super();
		}
	public Employee(int empId, String empName, String deptName, byte experience, String designation) {
		super();
		EmpId = empId;
		EmpName = empName;
		DeptName = deptName;
		Experience = experience;
		Designation = designation;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public byte getExperience() {
		return Experience;
	}
	public void setExperience(byte experience) {
		Experience = experience;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	

}
