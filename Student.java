/*a.Student class is a child class inherited from the parent Person Class. It contains the UIN, rank and email of person
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
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
			//default = freshman
			rank = Rank.Freshman;
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return super.getFirstName() + " " + super.getLastName() + ", Rank: " + getRank().toString() + ", UIN: " + getUIN();
	}
	
	
}
