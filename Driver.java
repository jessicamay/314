//import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamBuilder teamBuilder = new TeamBuilder();
		
		Utility util = new Utility();
		util.readerf("CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv");
		teamBuilder.setTeam("CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv", "results.txt");

		
	}

}
