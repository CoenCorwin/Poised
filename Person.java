
public class Person {
	
//	Create person attributes
	String name;
	String surname;
	int telephoneNumber;
	String emailAddress;
	String physicalAddress;
	
//	Creating constructor
	public Person(String name, String surname, int telephoneNumber, String emailAddress, String physicalAddress) {
		this.name = name;
		this.surname = surname;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress= physicalAddress;
	}
	

//	get and set update details
	
	public int getTelephoneNumber() {
			return telephoneNumber;
		}


	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}




	//	Create toString Methods
	public String toString() {
		String output = "";
		output += "\nName: " + name + " " + surname;
		output += "\nTelephone Number: " + telephoneNumber;
		output += "\nEmail Address: " + emailAddress;
		output += "\nPhysical Address: " + physicalAddress;
		
		return output;
	}
}