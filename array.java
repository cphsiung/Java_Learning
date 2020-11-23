// Chunpei Hsiung
// due date: 11/23 9:45am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a Java program to meet requirements for Operations On Arrays Test II section II. */

import java.util.Scanner;
public class array
{
   public static void main(String[] args)
      
      {
         // DECLARATION
         final int size = 20; // size for arrays
         int positiveSum = 0, negativeSum = 0, positiveCount = 0, negativeCount = 0;
         char repeat = 'n';
         int [] entry = new int [size];

         Scanner Input = new Scanner(System.in);      
         
         do {         
            positiveSum = 0; negativeSum = 0; positiveCount = 0; negativeCount = 0; // reset to zero when program restarts
            // INPUT      
            System.out.println("Please enter " + size + " integers below:");
            for (int i = 0; i < size; i++) {
               System.out.println("Please enter integer " + (i + 1) + ":");
               entry[i] = Input.nextInt();
               while (entry[i] < -100 || entry[i] > 100) {  
                  System.out.println("Integer must be between -100 and 100");
                  entry[i] = Input.nextInt();
               } // data validation
            }
                 
            // PROCESS
            // Get sum and count of positive and negative numbers
            for (int k = 0; k < size; k++) {
               if (entry[k] >= 0) {
                  positiveSum += entry[k];
                  positiveCount++;
               } else {
                  negativeSum += entry[k];
                  negativeCount++;
               }
            }
            
            // OUTPUT
            System.out.println("Sum of all positive numbers in the array: " + positiveSum); // sum of positive numbers
            System.out.println("Sum of all negative numbers in the array: " + negativeSum); // sum of negative numbers
            System.out.println("All positive odd numbers in the array:");  // positive odd numbers
            for (int j = 0; j < size; j++) {
               if(entry[j] >= 0 && entry[j] % 2 == 1)
                  System.out.print("\t" + entry[j]);
            }
            System.out.println("\nAll negative even numbers in the array:"); // negative even numbers
            for (int j = 0; j < size; j++) {
               if(entry[j] < 0 && entry[j] % 2 == 0)
                  System.out.print("\t" + entry[j]);
            }
            System.out.println("\nAll positive numbers in reverse order:"); // positive numbers in reverse order
            for (int j = size-1; j >= 0; j--) {
               if(entry[j] >= 0)
                  System.out.print("\t" + entry[j]);
            }
            System.out.println("\nAll negative numbers in the array:"); // all negative numbers
            for (int j = 0; j < size; j++) {
               if(entry[j] < 0)
                  System.out.print("\t" + entry[j]);
            }
            System.out.println("\nAll numbers in the array: "); // all numbers
            for (int j = 0; j < size; j++) {
               System.out.print("\t" + entry[j]);
            }
            System.out.println("\nThe count of negative numbers in the array: " + negativeCount); // count of negative numbers
            System.out.println("The count of positive numbers in the array: " + positiveCount); // count of positive numbers
            System.out.println("Do you want to repeat the program? y/n"); // choice to repeat the program
            repeat = Character.toLowerCase(Input.next().charAt(0));;
         } while (repeat == 'y');
      }
}