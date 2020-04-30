/*a. The driver holds the main function and drives the program
b.	Jessica Li 
c.	925008863
d.	jml0400@tamu.edu
*/
public class Driver {

	public static void main(String[] args) {
		// input file name: "CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv"
		// output file with teams : "results.txt
		// error log: ErrorlLog.txt
		TeamBuilder teamBuilder = new TeamBuilder();
		Utility util = new Utility();
		util.readerf("CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv");
		teamBuilder.setTeam("CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv", "results.txt");
	}

}
