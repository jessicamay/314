/*a.Person class is the parent class.  It contains the first and last name plus their respective setters/getters
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
public abstract class Person {
	String firstName;
	String lastName;
	
	// getters and setters for first and last name
	public String getFirstName() { 
		return firstName;
	}
	
	public void setFirstName(String firstName) { 
		this.firstName = firstName;
	}
	
	public String getLastName() { 
		return lastName;
	}
	
	public void setLastName(String lastName) { 
		this.lastName = lastName;
	}
	
	// toString function for name printing
	public String toString() { 
		return getFirstName() +" "+ getLastName();
	}
}
