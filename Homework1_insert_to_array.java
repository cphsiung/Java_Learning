// Chunpei Hsiung
// due date: 1/19 11:59pm
// Prof. Raymond Mitchell III
// CSE-41321 Winter 2021
/** program description
    implement	a	program	that	inserts	elements	into	an	array and analyze the Big-O performance of this	code*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class Homework1 {   
   public static void main(String[] args) throws IOException {                // O(n^2)
      // PrintWriter for output data to txt file
      PrintWriter Streem = new PrintWriter("output.txt");                     // O(1)
      // Setting to allow fine-tuning the granularity of the readings
      int NUM_READINGS = 60;                                                  // O(1)
      int INSERTS_PER_READING = 1000;                                         // O(1)
      
      // Start with an array containing 1 element
      int[] arr = {0};                                                        // O(1)
      
      // Print output headers
      Streem.println("Array length  \t\t\tNanoseconds per insert");           // O(1)
      System.out.println("Array length  Nanoseconds per insert");             // O(1)
      
      // Take NUM_READINGS readings
      for (int i = 0; i < NUM_READINGS; i++) {                                // O(n)
         // Each reading will be taken after INSERTS_PER_READING inserts
         long startTime = System.nanoTime();                                  // O(1)
         for (int j = 0; j < INSERTS_PER_READING; j++) {                      // O(n)
            int index = random(0, arr.length);                                // O(1)
            int value = random(0, 500);                                       // O(1)
            arr = insert(arr, index, value);                                  // O(1)
         }
         long stopTime = System.nanoTime();                                   // O(1)
         long timePerInsert = (stopTime - startTime) / INSERTS_PER_READING;   // O(1)
         
         // Output reading in tabular format
         System.out.println(arr.length + "\t\t\t\t\t" + timePerInsert);       // O(1)
         Streem.println(arr.length + "\t\t\t\t\t" + timePerInsert);           // O(1)
      }
      Streem.close();                                                         // O(1)
   }
      
   /** Method to generate random numbers */
   public static int random(int min, int max) {                               // O(1)
      int range = (max - min) + 1;                                            // O(1)
      return (int)(Math.random() * range) + min;                              // O(1)
   }
   
   /** Method to insert new value to an array */  
   public static int[] insert(int[] array, int index, int value) {            // O(n)
      // Create new array one larger than original array
      int[] newArray = new int [array.length + 1];                            // O(1)
      // Copy elements up to insert point from original array to new array
      for (int i = 0; i < index; i++) {                                       // O(n)
         newArray[i] = array[i];
      }
      // Place insert value into new array
      newArray[index] = value;                                                // O(1)
      // Copy elements after insert point from original array to new array
      for (int i = index + 1; i <= array.length; i++) {                       // O(n)
         newArray[i] = array[i - 1];                                          // O(1)
      }
      return newArray;                                                        // O(1)
   }
}