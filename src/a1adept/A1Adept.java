package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.
		int assignments = s.nextInt();
		int[] Total_Assignments = new int[assignments];
		int Total_Assignment_Sum = 0;
		for (int i = 0; i < assignments; i++) {
			Total_Assignments[i] = s.nextInt();
			Total_Assignment_Sum = Total_Assignment_Sum + Total_Assignments[i];
		}
		int Total_Participation = s.nextInt();
		int students = s.nextInt();
		for (int i = 0; i < students; i++) {
			String First_Name = s.next();
			String Last_Name = s.next();
			double Participation_Points = s.nextDouble();
			double[] Assignment_Grades = new double[assignments];
			double Assignment_Sum = 0;
			for (int m = 0; m < assignments; m++) {
				Assignment_Grades[m] = s.nextDouble();
				Assignment_Sum = Assignment_Sum + Assignment_Grades[m];
			}
			double Midterm = s.nextDouble();
			double Final_Exam = s.nextDouble();

			double Participation_Grade = 100 * (Participation_Points / (Total_Participation * 0.8));
			if (Participation_Grade > 100) {
				Participation_Grade = 100;
			}

			double Assignment_Grade = 100 * (Assignment_Sum / Total_Assignment_Sum);

			char First_Letter = First_Name.charAt(0);

			double WA = (Assignment_Grade * 0.40) + (Participation_Grade * 0.15) + (Midterm * 0.20)
					+ (Final_Exam * 0.25);

			String Letter_Grade = "";

			if (WA >= 94) {
				Letter_Grade = "A";
			} else if (WA < 94 && WA >= 90) {
				Letter_Grade = "A-";
			} else if (WA < 90 && WA >= 86) {
				Letter_Grade = "B+";
			} else if (WA < 86 && WA >= 83) {
				Letter_Grade = "B";
			} else if (WA < 83 && WA >= 80) {
				Letter_Grade = "B-";
			} else if (WA < 80 && WA >= 76) {
				Letter_Grade = "C+";
			} else if (WA < 76 && WA >= 73) {
				Letter_Grade = "C";
			} else if (WA < 73 && WA >= 70) {
				Letter_Grade = "C-";
			} else if (WA < 70 && WA >= 65) {
				Letter_Grade = "D+";
			} else if (WA < 65 && WA >= 60) {
				Letter_Grade = "D";
			} else if (WA < 60) {
				Letter_Grade = "F";
			}

			System.out.println(First_Letter + ". " + Last_Name + " " + Letter_Grade);

		}
	}

}
