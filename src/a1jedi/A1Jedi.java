package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.
		int sumA = 0;
		int sumAminus = 0;
		int sumBplus = 0;
		int sumB = 0;
		int sumBminus = 0;
		int sumCplus = 0;
		int sumC = 0;
		int sumCminus = 0;
		int sumDplus = 0;
		int sumD = 0;
		int sumF = 0;

		int assignments = s.nextInt();
		int[] total_Assignments = new int[assignments];
		int total_Assignment_Sum = 0;
		for (int i = 0; i < assignments; i++) {
			total_Assignments[i] = s.nextInt();
			total_Assignment_Sum = total_Assignment_Sum + total_Assignments[i];
		}
		int total_Participation = s.nextInt();
		int students = s.nextInt();
		double[] raw_Midterm = new double[students];
		double[] raw_Final = new double[students];
		double participation_Points;
		double[] assignment_Grades = new double[students];
		double[] participation_Grades = new double[students];
		for (int i = 0; i < students; i++) {
			String first_Name = s.next();
			String last_Name = s.next();
			participation_Points = s.nextDouble();
			participation_Grades[i] = 100 * (participation_Points / (total_Participation * 0.8));
			if (participation_Grades[i] > 100) {
				participation_Grades[i] = 100;
			}

			double assignment_Sum = 0;
			for (int m = 0; m < assignments; m++) {
				assignment_Sum = assignment_Sum + s.nextDouble();
			}
			raw_Midterm[i] = s.nextInt();
			raw_Final[i] = s.nextInt();

			assignment_Grades[i] = 100 * (assignment_Sum / total_Assignment_Sum);
		}

		double finalsSum = 0;
		for (int m = 0; m < students; m++) {
			finalsSum = finalsSum + raw_Final[m];
		}

		double avgFinal = finalsSum / students;

		double[] differenceFinal = new double[students];
		for (int n = 0; n < students; n++) {
			differenceFinal[n] = (raw_Final[n] - avgFinal) * (raw_Final[n] - avgFinal);
		}

		double differenceFinalSum = 0;
		for (int p = 0; p < students; p++) {
			differenceFinalSum = differenceFinalSum + differenceFinal[p];
		}

		double finalStdDev = Math.sqrt(differenceFinalSum / students);

		double[] normalizedFinals = new double[students];
		double[] curvedFPercent = new double[students];
		for (int v = 0; v < students; v++) {
			normalizedFinals[v] = (raw_Final[v] - avgFinal) / finalStdDev;
			if (normalizedFinals[v] >= 2.0) {
				curvedFPercent[v] = 100.0;
			} else if (normalizedFinals[v] < 2.0 && normalizedFinals[v] > 1.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - 1.0) / (2.0 - 1.0)) * (100.0 - 94.0)) + 94.0;
			} else if (normalizedFinals[v] == 1.0) {
				curvedFPercent[v] = 94.0;
			} else if (normalizedFinals[v] < 1.0 && normalizedFinals[v] > 0.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - 0.0) / (1.0 - 0.0)) * (94.0 - 85.0)) + 85.0;
			} else if (normalizedFinals[v] == 0.0) {
				curvedFPercent[v] = 85.0;
			} else if (normalizedFinals[v] < 0.0 && normalizedFinals[v] > -1.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - -1.0) / (0.0 - -1.0)) * (85.0 - 75.0)) + 75.0;
			} else if (normalizedFinals[v] == -1.0) {
				curvedFPercent[v] = 75.0;
			} else if (normalizedFinals[v] < -1.0 && normalizedFinals[v] > -1.5) {
				curvedFPercent[v] = (((normalizedFinals[v] - -1.5) / (-1.0 - -1.5)) * (75.0 - 65.0)) + 65.0;
			} else if (normalizedFinals[v] == -1.5) {
				curvedFPercent[v] = 65.0;
			} else if (normalizedFinals[v] < -1.5 && normalizedFinals[v] > -2.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - -2.0) / (-1.5 - -2.0)) * (65.0 - 55.0)) + 55.0;
			} else if (normalizedFinals[v] == -2.0) {
				curvedFPercent[v] = 55.0;
			} else if (normalizedFinals[v] < -2.0 && normalizedFinals[v] > -3.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - -3.0) / (-2.0 - -3.0)) * (55.0 - 30.0)) + 30.0;
			} else if (normalizedFinals[v] == -3.0) {
				curvedFPercent[v] = 30.0;
			} else if (normalizedFinals[v] < -3.0 && normalizedFinals[v] > -4.0) {
				curvedFPercent[v] = (((normalizedFinals[v] - -4.0) / (-3.0 - -4.0)) * (30.0 - 0.0)) + 0.0;
			} else if (normalizedFinals[v] <= -4.0) {
				curvedFPercent[v] = 0.0;
			}
		}

		double midtermSum = 0;
		for (int m = 0; m < students; m++) {
			midtermSum = midtermSum + raw_Midterm[m];
		}

		double avgMidterm = midtermSum / students;

		double[] differenceMidterm = new double[students];
		for (int n = 0; n < students; n++) {
			differenceMidterm[n] = (raw_Midterm[n] - avgMidterm) * (raw_Midterm[n] - avgMidterm);
		}

		double differenceMidtermSum = 0;
		for (int p = 0; p < students; p++) {
			differenceMidtermSum = (differenceMidtermSum + differenceMidterm[p]);
		}

		double midtermStdDev = Math.sqrt(differenceMidtermSum / students);

		double[] normalizedMTs = new double[students];
		double[] curvedMTPercent = new double[students];
		for (int v = 0; v < students; v++) {
			normalizedMTs[v] = (raw_Midterm[v] - avgMidterm) / midtermStdDev;
			if (normalizedMTs[v] >= 2.0) {
				curvedMTPercent[v] = 100.0;
			} else if (normalizedMTs[v] < 2.0 && normalizedMTs[v] > 1.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - 1.0) / (2.0 - 1.0)) * (100.0 - 94.0)) + 94.0;
			} else if (normalizedMTs[v] == 1.0) {
				curvedMTPercent[v] = 94.0;
			} else if (normalizedMTs[v] < 1.0 && normalizedMTs[v] > 0.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - 0.0) / (1.0 - 0.0)) * (94.0 - 85.0)) + 85.0;
			} else if (normalizedMTs[v] == 0.0) {
				curvedMTPercent[v] = 85.0;
			} else if (normalizedMTs[v] < 0.0 && normalizedMTs[v] > -1.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - -1.0) / (0.0 - -1.0)) * (85.0 - 75.0)) + 75.0;
			} else if (normalizedMTs[v] == -1.0) {
				curvedMTPercent[v] = 75.0;
			} else if (normalizedMTs[v] < -1.0 && normalizedMTs[v] > -1.5) {
				curvedMTPercent[v] = (((normalizedMTs[v] - -1.5) / (-1.0 - -1.5)) * (75.0 - 65.0)) + 65.0;
			} else if (normalizedMTs[v] == -1.5) {
				curvedMTPercent[v] = 65.0;
			} else if (normalizedMTs[v] < -1.5 && normalizedMTs[v] > -2.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - -2.0) / (-1.5 - -2.0)) * (65.0 - 55.0)) + 55.0;
			} else if (normalizedMTs[v] == -2.0) {
				curvedMTPercent[v] = 55.0;
			} else if (normalizedMTs[v] < -2.0 && normalizedMTs[v] > -3.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - -3.0) / (-2.0 - -3.0)) * (55.0 - 30.0)) + 30.0;
			} else if (normalizedMTs[v] == -3.0) {
				curvedMTPercent[v] = 30.0;
			} else if (normalizedMTs[v] < -3.0 && normalizedMTs[v] > -4.0) {
				curvedMTPercent[v] = (((normalizedMTs[v] - -4.0) / (-3.0 - -4.0)) * (30.0 - 0.0)) + 0.0;
			} else if (normalizedMTs[v] <= -4.0) {
				curvedMTPercent[v] = 0.0;
			}
		}

		double[] WAs = new double[students];
		for (int c = 0; c < students; c++) {
			WAs[c] = (assignment_Grades[c] * 0.40) + (participation_Grades[c] * 0.15) + (curvedMTPercent[c] * 0.20)
					+ (curvedFPercent[c] * 0.25);
			if (WAs[c] >= 94) {
				// Letter_Grade = "A";
				sumA++;
			} else if (WAs[c] < 94 && WAs[c] >= 90) {
				// Letter_Grade = "A-";
				sumAminus++;
			} else if (WAs[c] < 90 && WAs[c] >= 86) {
				// Letter_Grade = "B+";
				sumBplus++;
			} else if (WAs[c] < 86 && WAs[c] >= 83) {
				// Letter_Grade = "B";
				sumB++;
			} else if (WAs[c] < 83 && WAs[c] >= 80) {
				// Letter_Grade = "B-";
				sumBminus++;
			} else if (WAs[c] < 80 && WAs[c] >= 76) {
				// Letter_Grade = "C+";
				sumCplus++;
			} else if (WAs[c] < 76 && WAs[c] >= 73) {
				// Letter_Grade = "C";
				sumC++;
			} else if (WAs[c] < 73 && WAs[c] >= 70) {
				// Letter_Grade = "C-";
				sumCminus++;
			} else if (WAs[c] < 70 && WAs[c] >= 65) {
				// Letter_Grade = "D+";
				sumDplus++;
			} else if (WAs[c] < 65 && WAs[c] >= 60) {
				// Letter_Grade = "D";
				sumD++;
			} else if (WAs[c] < 60) {
				// Letter_Grade = "F";
				sumF++;
			}

		}
		System.out.println("A : " + sumA);
		System.out.println("A-: " + sumAminus);
		System.out.println("B+: " + sumBplus);
		System.out.println("B : " + sumB);
		System.out.println("B-: " + sumBminus);
		System.out.println("C+: " + sumCplus);
		System.out.println("C : " + sumC);
		System.out.println("C-: " + sumCminus);
		System.out.println("D+: " + sumDplus);
		System.out.println("D : " + sumD);
		System.out.println("F : " + sumF);
	}

}
