// Chunpei Hsiung
// due date: 1/19 11:59pm
// Prof. Raymond Mitchell III
// CSE-41321 Winter 2021
/* program description
    insert new value to an existing array*/
import java.util.*;
import java.lang.*;

public class Homework1 {
   public static void main(String[] args) {
//       int size = 5, value = 0, index = 0;
//       int[] arr = new int[size];
//       for (int i = 0; i < size; i++) {
//          arr[i] = i * 2;
//       }
//       Scanner Input = new Scanner(System.in);
//       System.out.println("Please enter the value you want to insert:");
//       value = Input.nextInt();
//       System.out.println("The array currently has " + size + " positions.");
//       System.out.println("Please enter the index position where the value will be inserted:");
//       index = Input.nextInt();
      
//       System.out.println(Arrays.toString(arr));
//       arr = insert(arr, index, value);
//       System.out.println(Arrays.toString(arr));
         
         // Setting to allow fine-tuning the granularity of the readings
         int NUM_READINGS = 60;
         int INSERTS_PER_READING = 1000;
         
         // Start with an array containing 1 element
         int[] arr = {0};
         
         // Take NUM_READINGS readings
         long startTime = System.nanoTime();
         for (int i = 0; i < NUM_READINGS; i++) {
            // Each reading will be taken after INSERTS_PER_READING inserts
            int index = random(0, arr.length);
            int value = random(0, 100);
            arr = insert(arr, index, value);
         }
   }
      
      public static int random(int min, int max) {
         int range = (max - min) + 1;
         return (int)(Math.random() * range) + min;
      }
        
      public static int[] insert(int[] array, int index, int value) {
         // Create new array one larger than original array
         int[] newArray = new int [array.length + 1];
         // Copy elements up to insert point from original array to new array
         for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
         }
         // Place insert value into new array
         newArray[index] = value;
         // Copy elements after insert point from original array to new array
         for (int i = index + 1; i <= array.length; i++) {
            newArray[i] = array[i - 1];
         }
         return newArray;
      }
}