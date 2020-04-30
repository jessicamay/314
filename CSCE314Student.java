
public class CSCE314Student extends Student {
	int JavaKnowledge;
	int section;
	
	//initialize
	public CSCE314Student() {
		JavaKnowledge = 0;
		section = 0;
	}
	
	public int getJK() {
		return JavaKnowledge;
	}
	public void setJK(int JK) {
		JavaKnowledge = JK;
	}
	
	public int getSection() {
		return section;
	}
	public void setSection(int sect) {
		section = sect;
	}
	public String toString() { 
		return String.format("%-25s", this.getFirstName() + " " + this.getLastName() + " (" + Integer.toString(JavaKnowledge) + ") "); 
	}
}
