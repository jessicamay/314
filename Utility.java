/*a.Utility class does the file reading and writing for input, output and error log 
 * as well an additional substitute array list in case someone's student data was missing
 * Regex code from online was used from stack overflow 
 * 
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
import java.io.*;
import java.util.*;

public class Utility {
	boolean readFile;
	boolean writeResults;
	
	ArrayList<String> errorsList = new ArrayList<String>();
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
			addError(e.toString()); // prints error(s) to file 
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
			// I understand this is technically an online source, but the idea was given from piazza in the discussions.
			
			String[] lineSplit = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			//System.out.println(Arrays.toString(lineSplit));
			CSCE314Student tempStudent = new CSCE314Student();
			try { // reordered for error log!
				// Index [4] = name
				tempStudent.setFirstName(lineSplit[4].split(" ", 0)[0]); 
				tempStudent.setLastName(lineSplit[4].split(" ", 0)[1]); 
				
				// Index [5] = Section
				tempStudent.setSection(Integer.parseInt(lineSplit[5].split(" ", 0)[0]));
				int section = Integer.parseInt(lineSplit[5].split(" ", 0)[0]);
				
				// Index [1] = Java Knowledge (JK)
				if (lineSplit[1] == "" || Integer.parseInt(lineSplit[1]) > 5 || Integer.parseInt(lineSplit[1]) < 1 )  {
					// set default Java Knowledge to 1
					tempStudent.setJK(1);
				}
				else {
					tempStudent.setJK(Integer.parseInt(lineSplit[1])); 
				}
				
				if ((sectionsList.contains(section)) == false) {
					sectionsList.add(section);
				}
				//Index [6] = UIN from email,  split at the @ and use the front half 
				tempStudent.setUIN(lineSplit[6].split("@", 0)[0]);
				
				//Index [7] = Rank - errors in the provided file
				try {
					if ((Integer.parseInt(lineSplit[7]) >= 1) && (Integer.parseInt(lineSplit[7])<=4)) {
						tempStudent.setRank(Integer.parseInt(lineSplit[7]));
					}
					else {
						addError("Student " + tempStudent.getFirstName() +" "+tempStudent.getLastName()+ "'s rank is invalid rank integer.");
					}
				}
				catch (Exception e) {
					addError("Student " + tempStudent.getFirstName() +" "+tempStudent.getLastName()+"'s rank is not specified or invalid.");
				}
				// append the student to the temporary Array List of students
				tempAL.add(tempStudent);
			}
			catch (Exception e){
				addError("Issue with Student " + tempStudent.getFirstName()+" "+tempStudent.getLastName()+"'s data, not paired. Error :" + e.toString());
				addSub(tempStudent);
			}
		}
		//System.out.print(sectionsList);
		readFile = true;
		return tempAL;	
	}
	
	ArrayList<CSCE314Student> subs = new ArrayList<CSCE314Student> ();
	public void addSub(CSCE314Student temp) {
		subs.add(temp);
	}
	
	public ArrayList<CSCE314Student> subList() {
		return subs;
	}
	
	// returns status of readFile
	public boolean readFile() {
		return readFile;
	}

	// write Results takes in the teams array list and the subs array list
	public boolean writeResults(ArrayList<CSCE314Student[]> writeOut, ArrayList<CSCE314Student> subs) {
		PrintWriter outFile = null;
		try{
			outFile = new PrintWriter("results.txt");
			for(int i = 0; i < writeOut.size(); i++) {
				outFile.print(writeOut.get(i)[1].getSection()+ " - ");
				// object created for pair always have 2 people 
				for(int j = 0; j < 2; j++) {
					outFile.print(writeOut.get(i)[j].toString() + " ");
				}
				outFile.print("\n");
			}
			// print the Substitutes at the end of file
			outFile.print("\n" + "Substitutes: \n");
			for(int i = 0; i < subs.size(); i++) {
				outFile.print(subs.get(i).getSection()+ " - " + subs.get(i).toString());
			}
			outFile.close();
			writeResults = true;
		}
		catch (Exception e){
			System.out.println("Issue with Results file: Check ErrorLog.");
			addError("Issue with outputFile: " + e.toString());  // prints error(s)
			writeResults = false;
			System.exit(0); // Exits entire program
		}
		// Error log file creation and printing
		try { 
			PrintWriter eWriter = new PrintWriter("ErrorLog.txt");
			for (int i=0; i < errorsList.size(); i++) {
				eWriter.print(errorsList.get(i) + "\n");
			}
			eWriter.close();
		}
		catch (IOException e) { 
			addError("Not able to write to ErrorLog.txt file");	
		}
		outFile.close();
		return writeResults;
	}

	public ArrayList<Integer> getSectionsList() {
		return sectionsList;
	}
	
	public void addError(String newError) {
		errorsList.add(newError);
	}
}
