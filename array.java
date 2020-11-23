// Chunpei Hsiung
// due date: 11/18 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a Java program to create a payroll report based on the assumptions and requirements. */

import java.util.Scanner;
public class array
{
   public static void main(String[] args)
      
      {
         // DECLARATION
         final int size = 5; // size for arrays
         double positiveSum = 0, negativeSum = 0, positiveCount = 0, negativeCount = 0;
         char repeat = 'n';
         int [] entry = new int [size];
         int [] positive = new int [size];
         int [] negative = new int [size];

         Scanner Input = new Scanner(System.in);      
         
         // INPUT      
         System.out.println("Please enter " + size + " integers below:");
         for (int i = 0; i < size; i++) {
            System.out.println("Please enter integer " + i + 1 + ":");
            entry[i] = Input.nextInt();
            while (entry[i] < -100 || entry[i] > 100) {
               System.out.println("Integer must be between -100 and 100");
               entry[i] = Input.nextInt();
            }
         }
              
         // PROCESS
         for (int k = 0; k < size; k++) {
            if (entry[k] > 0) {
               positive[k] = entry[k];
               positiveSum += entry[k];
               positiveCount += 1;
            } else (entry[k] < 0) {
               negative[k] = entry[k];
               negativeSum += entry[k];
               negativeCount += 1;
            }
         }
         
         // OUTPUT
         System.out.println("Sum of all positive numbers in the array: " + positiveSum);
         System.out.println("Sum of all negative numbers in the array: " + negativeSum);
         System.out.println("All positive odd numbers in the array:");
         for (int j = 0; j < size; j++) {
            if(positive[j] % 2 == 1) {
            System.out.println("positive[j]\t");
            }
         }
         System.out.println("All negative even numbers in the array:");
         for (int j = 0; j < size; j++) {
            if(negative[j] % 2 == 0) {
            System.out.println("negative[j]\t");
            }
         }
         System.out.println("All positive numbers in reverse order:");
         for (int j = size-1; j >= 0; j--) {
            System.out.println("positive[j]\t");
         }
         System.out.println("All negative numbers in the array:");
         for (int j = 0; j < size; j++) {
            System.out.println("negative[j]\t");
            }
         }
         
         System.out.println("All numbers in the array: ");
         for (int j = 0; j < size; j++) {
            System.out.println("entry[j]\t");
            }
         }
         
         System.out.println("The count of negative numbers in the array: " + negativeCount);
         System.out.println("The count of negative numbers in the array: " + positiveCount);
      }
}