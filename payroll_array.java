// Chunpei Hsiung
// due date: 11/18 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a Java program to create a payroll report based on the assumptions and requirements. */

import java.util.Scanner;
public class payroll_array
{
   public static void main(String[] args)
      
      {
         // Declaration
         double stateTaxRate = 0.06, fedTaxRate = 0.12, unionFeeRate = 0.02, overtimeRate = 0.5; // contants for tax & fee rates
         final int size = 2; // size for arrays
         String [] firstName = new String [size];
         String [] lastName = new String [size];
         char [] middleInit = new char [size];
         double [] hours = new double [size];
         double [] rates = new double [size];
         double [] stateTax = new double [size];
         double [] fedTax = new double [size];
         double [] unionFee = new double [size];
         double [] netPay = new double [size];
         double [] grossPay = new double [size]; 

         Scanner Input = new Scanner(System.in);      
         
         // Input      
         for (int i = 0; i < size; i++) {
         
         }
              
         // Process

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