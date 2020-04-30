import java.io.*;
import java.util.*;

public class Utility {
	boolean readFile;
	boolean writeResults;
	
	ArrayList<Integer> sectionsList = new ArrayList<Integer> ();
	
	// read file function
	public ArrayList<CSCE314Student> readerf(String fileName){
		
		ArrayList<CSCE314Student> tempAL = new ArrayList<CSCE314Student> ();
		File inputFile = new File(fileName);
		Scanner scan = null;
		
		try {
			scan = new Scanner(inputFile);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			readFile = false;
			System.exit(0); // Exits entire program
		}
		try {
			//skip the top heading line
			scan.nextLine();
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		
		while(scan.hasNextLine()){
			
			String line = scan.nextLine();
			// source: https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
			// split on the comma only if that comma has an even number of quotes ahead of it.
			String[] lineSplit = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			//System.out.println(Arrays.toString(lineSplit));
			CSCE314Student tempStudent = new CSCE314Student();
			
			try {
				// Index [1] = Java Knowledge (JK)
				tempStudent.setJK(Integer.parseInt(lineSplit[1])); 
				
				// Index [4] = name
				tempStudent.setFirstName(lineSplit[4].split(" ", 0)[0]); 
				tempStudent.setLastName(lineSplit[4].split(" ", 0)[1]); 
				
				// Index [5] = Section
				tempStudent.setSection(Integer.parseInt(lineSplit[5].split(" ", 0)[0]));
				int section = Integer.parseInt(lineSplit[5].split(" ", 0)[0]);
				
				if ((sectionsList.contains(section)) == false) {
					sectionsList.add(section);
				}
				//Index [6] = UIN from email,  split at the @ and use the front half 
				tempStudent.setUIN(lineSplit[6].split("@", 0)[0]);
				
				//Index [7] = rank
				//tempStudent.setRank(Integer.parseInt(lineSplit[7]));
				 
				tempAL.add(tempStudent);
			}
			catch (Exception e){
				
			}
			
		}
		//System.out.print(sectionsList);
		return tempAL;	
		
	}
	
	public ArrayList<Integer> getSectionsList() {
		return sectionsList;
		
	}
	
}
