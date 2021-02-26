package ProjectManagementApp;

public class Project {
	private int numberOfTechnologies;
	private  int id;
	private String name;
	private String description;
	private int teamSize;
	private int duration;
	private String []technologies=new String[numberOfTechnologies];
	
	public Project() {
		super();
	}
	public Project(int id,String name,String description,int teamSize,int duration,String[] technologies,int numberOfTechnologies) {
		super();
		this.id=id;
		this.name=name;
		this.description=description;
		this.teamSize=teamSize;
		this.duration=duration;
		this.technologies=technologies;
		this.numberOfTechnologies=numberOfTechnologies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize=teamSize;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration=duration;
	}
	public String[] getTechnologies(){
		return technologies;
	}
	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}
	public void getTechnologiesDetails() {
		for (int i = 0; i < technologies.length; i++) {
			System.out.print(technologies[i]+", ");
		}
		System.out.println();
	}
	
	

}
