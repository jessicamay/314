import java.util.ArrayList;

public class TeamBuilder {
	Utility util = new Utility();
	ArrayList<Integer> sectionsList = util.getSectionsList();
	JavaKnowledgeComparator Comparison = new JavaKnowledgeComparator();
	
	/*	Trying to use dynamic array lists but couldn't get it to work 
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
	ArrayList<CSCE314Student> otherSections = new ArrayList<CSCE314Student>();
	ArrayList<CSCE314Student> subs = new ArrayList<CSCE314Student>();
	ArrayList<CSCE314Student[]> teams = new ArrayList<CSCE314Student[]>(); 
	
	public void setTeam(String fileReadName, String fileWriteName) {	
		allStudents = util.readerf(fileReadName);
		// This sorts all the students by their Java Knowledge Numbers
		allStudents.sort(Comparison);
		
		// sorts the sorted ArrayList by Sections
		for(int i = 0; i < allStudents.size(); ++i) {
			CSCE314Student temp = allStudents.get(i);
			// System.out.print(temp.getFirstName()+ " " + temp.getJK()+ "\n");
			if(temp.getSection() == 502) {
				section502.add(temp);
			}
			else if(temp.getSection() == 503) {
				section503.add(temp);
			}
			else {
				otherSections.add(temp);
			}
		}
		
		// pairing section 502
		if (section502.size() % 2 == 0 ) {
			int j = section502.size()-1;
			for(int i = 0; i < section502.size()/2; ++i) {
				CSCE314Student[] section502pair = new CSCE314Student[2];
				section502pair[0] = section502.get(i);
				section502pair[1] = section502.get(j);
				teams.add(section502pair);
				j--;
			}
		}
		else {
			//remove last guy cause he's got enough JK
			subs.add(section502.get(section502.size()-1));
			section502.remove(section502.size()-1);	
			int j = section502.size()-1;
			for(int i = 0; i < section502.size()/2; ++i) {
				CSCE314Student[] section502pair = new CSCE314Student[2];
				section502pair[0] = section502.get(i);
				section502pair[1] = section502.get(j);
				teams.add(section502pair);
				j--;
				
			}
			
		}
		
		// pairing section 503 
		if (section503.size() % 2 == 0 ) {
			int k = section503.size()-1;	
			for(int i = 0; i < section503.size()/2; ++i) {
				CSCE314Student[] section503pair = new CSCE314Student[2];
				section503pair[0] = section503.get(i);
				section503pair[1] = section503.get(k);
				teams.add(section503pair);
				k--;
			}
		}
			
		else {
			//remove last guy cause he's got enough JK
			subs.add(section503.get(section503.size()-1));
			section503.remove(section503.size()-1);	
			int k = section503.size()-1;	
			for(int i = 0; i < section503.size()/2; ++i) {
				CSCE314Student[] section503pair = new CSCE314Student[2];
				section503pair[0] = section503.get(i);
				section503pair[1] = section503.get(k);
				teams.add(section503pair);
				k--;
			}
			
		}
		if (!otherSections.isEmpty()) { 
			if (otherSections.size() % 2 == 0 ) {
				int k = otherSections.size()-1;	
				for(int i = 0; i < otherSections.size()/2; ++i) {
					CSCE314Student[] pair = new CSCE314Student[2];
					pair[0] = otherSections.get(i);
					pair[1] = otherSections.get(k);
					teams.add(pair);
					k--;
				}
			}
			else {
				//remove last guy cause he's got enough JK
				subs.add(otherSections.get(otherSections.size()-1));
				otherSections.remove(otherSections.size()-1);	
				int k = otherSections.size()-1;	
				for(int i = 0; i < otherSections.size()/2; ++i) {
					CSCE314Student[] pair = new CSCE314Student[2];
					pair[0] = otherSections.get(i);
					pair[1] = otherSections.get(k);
					teams.add(pair);
					k--;
				}
			}
		}
		
		util.writeResults(teams, subs);
	}
	
}
