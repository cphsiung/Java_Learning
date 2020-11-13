// Chunpei Hsiung
// due date: 11/16 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a java program to calculate the average of three test scores for a class of 10 students. */

import java.util.Scanner;
public class scores_array
{
   public static void main(String[] args)
      
      {
         // Declaration
         final int size = 10; // size for arrays
         double total = 0;
         double [] score1 = new double [size];
         double [] score2 = new double [size];
         double [] score3 = new double [size];
         double [] avg = new double [size];
         String [] firstName = new String [size];
         String [] lastName = new String [size];
         char [] middleInit = new char [size];
         
         Scanner Input = new Scanner(System.in);      
         
         // Input      
         for (int i = 0; i < size; i++) {
            System.out.println("Please enter first name for student" + (i + 1) + " :"); // i + 1 to get student count
            firstName[i] = Input.next();
            System.out.println("Please enter middle name initial for student" + (i + 1) + " :");
            middleInit[i] = Input.next().charAt(0);
            System.out.println("Please enter last name for student" + (i + 1) + " :");
            lastName[i] = Input.next();
            do {
               System.out.println("Please enter score 1 for student" + (i + 1) + " :");
               System.out.println("Score needs to be between 0 and 100.");
               score1[i] = Input.nextDouble();
            } while (score1[i] < 0 || score1[i] > 100); // validate score input is between 0 and 100
            
            do {
               System.out.println("Please enter score 2 for student" + (i + 1) + " :");
               System.out.println("Score needs to be between 0 and 100.");
               score2[i] = Input.nextDouble();
            } while (score2[i] < 0 || score2[i] > 100);
            do {
               System.out.println("Please enter score 3 for student" + (i + 1) + " :");
               System.out.println("Score needs to be between 0 and 100.");
               score3[i] = Input.nextDouble();      
            } while (score3[i] < 0 || score3[i] > 100);         
         }
              
         // Process
         // calculate student average
         for (int k = 0; k < size; k++) {
            avg[k] = (score1[k] + score2[k] + score3[k])/3;
         }
         
         // calculate class total
         for (int ct = 0; ct < size; ct++) {
            total += avg[ct];
         }

         // Output
         System.out.println("                    CSC-117-01 Fall 2020");
         System.out.println("==================================================================");
         System.out.printf("%-12s %-3s %-12s %8s %8s %8s %8s\n", "First Name", "MI", "Last Name", "Test 1", "Test 2", "Test 3", "Average");
         System.out.printf("%-12s %-3s %-12s %8s %8s %8s %8s\n", "============", "===", "===========", "========", "========", "========", "=========");

         for (int j = 0; j < size; j++) {
            System.out.printf("%-13s", firstName[j]);
            System.out.printf("%-4C", middleInit[j]); // capital C to format to capital letter
            System.out.printf("%-12s", lastName[j]);
            System.out.printf("%9.1f", score1[j]);
            System.out.printf("%9.1f", score2[j]);
            System.out.printf("%9.1f", score3[j]);
            System.out.printf("%9.1f\n", avg[j]);
         }
         
         System.out.print("\nClass Average: ");
         System.out.printf("%.1f", (total/size));
      }
}