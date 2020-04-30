/*a.CSCE314Student class is a child class inherited from the Student Class. It contains the section and 
 *  Java Knowledge info for the student 
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
public class CSCE314Student extends Student {
	int JavaKnowledge;
	int section;
	
	//initialize
	public CSCE314Student() {
		super();
		JavaKnowledge = 0;
		section = 0;
	}
	
	public int getJK() {
		return JavaKnowledge;
	}
	public void setJK(int JK) {
		if (JK <1 || JK >5) {
			JavaKnowledge = 1;
		}
		else {
			JavaKnowledge = JK;	
		}	
	}
	
	public int getSection() {
		return section;
	}
	public void setSection(int sect) {
		section = sect;
	}
	public String toString() { 
		return String.format("%-28s", super.getFirstName() + " " + super.getLastName() + " (" + Integer.toString(JavaKnowledge) + ") "); 
	}
}
