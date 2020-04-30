import java.util.ArrayList;

public class TeamBuilder {
	
	ArrayList<CSCE314Student[]> teams = new ArrayList<CSCE314Student[]>(); // This is to hold teams of 2 students
	Utility util = new Utility();
	ArrayList<Integer> sectionsList = util.getSectionsList();
	JavaKnowledgeComparator Comparison = new JavaKnowledgeComparator();
	
	/*	
	int a = sectionsList.size();

	ArrayList<ArrayList<CSCE314Student>> sectionClassList = new ArrayList<>();
	for(int i=0 ;i < a;i++){
		ArrayList<CSCE314Student> myGroup = new ArrayList<>();
		sectionClassList.add(myGroup);
	}
*/	
	ArrayList<CSCE314Student> allStudents = new ArrayList<CSCE314Student>();
	ArrayList<CSCE314Student> section502 = new ArrayList<CSCE314Student>();
	ArrayList<CSCE314Student> section503 = new ArrayList<CSCE314Student>();
	
	public void setTeam(String fileReadName, String fileWriteName) {	
		allStudents = util.readerf(fileReadName);
	// This sorts all the students by their Java Knowledge
		allStudents.sort(Comparison);
		
		System.out.print(allStudents);
	
	
	}
}
