package ProjectAllocation;

public class Manager {
	private String managerId;
	private String managerName;
	private String department;
	private Project[] projects;

	public Manager() {
		super();
	}

	public Manager(String managerId, String managerName, String department, Project[] projects) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.department = department;
		this.projects = projects;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void setProjects(Project[] projects) {
		this.projects = projects;
	}

}
