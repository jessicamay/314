
//child class of the parent class Person
//person is a student 

public class Student extends Person {
	String UIN;
	Rank rank;
	String email;
	
	public Student() {
		super();
		UIN = "";
		rank = Rank.Senior;
	}
	
	public String getUIN() { // Getter for UIN
		return UIN;
	}
	
	public void setUIN(String UIN) { // Setter for UIN
		this.UIN = UIN;
	}
	
	public enum Rank {
		Freshman, Sophomore, Junior, Senior;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setRank(int i) {
		if (i == 1) {
			rank = Rank.Freshman;
		}
		else if (i == 2) {
			rank = Rank.Sophomore;
		}
		else if (i == 3) {
			rank = Rank.Junior;
		}
		else if (i == 4) {
			rank = Rank.Senior; 
		}
		else {
			//shouldn't happen because of try catch in utility but insurance!
			System.out.println("Error with setting rank");
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return 
	}
	
	
}
