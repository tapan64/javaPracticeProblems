package ProjectAllocation;

public class Project {
	private String projectId;
	private String projectName;
	private byte projectDuration;

	public Project() {
		super();
	}

	public Project(String projectId, String projectName, byte projectDuration) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDuration = projectDuration;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public byte getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(byte projectDuration) {
		this.projectDuration = projectDuration;
	}

}
