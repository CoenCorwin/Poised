import java.util.Date;

public class Project {

//	Create project attributes
	int projectNumber;
	String projectName;
	String buildingType;
	String physicalAddress;
	int erfNumber;
	Double totalFee;
	Double amountPaid;
	String deadline;
	String projectCompleted;
	Date dateCompleted;
	
//	Adding people in the project
	Person Architect;
	Person Customer;
	Person Contractor;
	
//	create constructor
	public Project(int projectNumber, String projectName, String buildingType, String physicalAddress, int erfNumber, Double totalFee, Double amountPaid, String deadline,
			 		String projectCompleted, Date dateCompleted, Person Architect, Person Customer, Person Contractor) {
		
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.amountPaid = amountPaid;
		this.deadline = deadline;
		this.projectCompleted = projectCompleted;
		this.dateCompleted = dateCompleted;
		this.Architect = Architect;
		this.Customer = Customer;
		this.Contractor = Contractor;
	}
	
//	get project name
	public String getProjectName() {
		return projectName;

	}

	
	//	get deadline 
	public String getDeadLine() {
		return deadline;
		
	}
	
//	get amount paid 
	public double getAmountPaid() {
		return amountPaid;
		
	}
	
//	get project completed 
	public String getProjectCompleted() {
		return projectCompleted;
		
	}
	
//	get date completed 
	public Date getDateCompleted() {
		return dateCompleted;
		
	}
	
//	set update project
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void setProjectCompleted(String projectCompleted) {
		this.projectCompleted = projectCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	
	
//	create toString methods
	public String toString() {
		
		String output = "";
		output += "\nProject Number: " + projectNumber;
		output += "\nProject Name: " + projectName;
		output += "\nBuilding Type: " + buildingType;
		output += "\nPhysical Address: " + physicalAddress;
		output += "\nErf Number: " + erfNumber;
		output += "\nTotal fee: " + totalFee;
		output += "\nAmount Paid: " + amountPaid;
		output += "\nDeadline: " + deadline;
		output += "\nIs Project Completed: " + projectCompleted;
		output += "\nCompleted Date: " + dateCompleted;
		
		return output;
	}

}
