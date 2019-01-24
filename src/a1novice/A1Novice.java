package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		// Put your code here.
		int students = s.nextInt();
		for (int i = 0; i < students; i++) {
			String First_Name = s.next();
			String Last_Name = s.next();
			double Assignment_Grade = s.nextDouble();
			double Participation_Grade = s.nextDouble();
			double Midterm = s.nextDouble();
			double Final_Exam = s.nextDouble();

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
