package CODSOFT;

import java.util.Scanner;

class StudentGrades {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int num = sc.nextInt();
        int marks[] = new int[num];
        int totalMarks = 0;
        for (int i = 0; i < num; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + "(out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }
        double avgPercentage = (double) totalMarks / num;
        char grade = calcGrade(avgPercentage);
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }

    private static char calcGrade(double averagePercentage) {
        if (averagePercentage >= 90)
            return 'A';
        else if (averagePercentage >= 80)
            return 'B';
        else if (averagePercentage >= 70)
            return 'C';
        else if (averagePercentage >= 60)
            return 'D';
        else
            return 'F';
    }
}