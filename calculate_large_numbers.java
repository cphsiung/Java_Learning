// Chunpei Hsiung
// due date: 2/9 11:59pm
// Prof. Raymond Mitchell III
// CSE-41321 Winter 2021
/** program description
    using stacks to add numbers of any size*/
import java.util.*;

public class calculate_large_numbers { 
   public static void main(String[] args) {
   
   // Demonstrate adding three pairs of large numbers
   addLargeNumbers("9223372036854775820", "8129498165026350236");
   addLargeNumbers("9999999999999999999", "8129498165026350236");
   addLargeNumbers("18274364583929273748525", "9223372036854775820");

   }

   /**Method to build stacks based on number input*/
   static Stack<String> buildStack(String numInput) {
      String[] digits = numInput.split("(?<=.)");
      Stack<String> sample = new Stack<String>();
      
      for (int i = 0; i < digits.length; i++) {
         sample.push(digits[i]);
      }
      return sample;
   }
   
   /**Method to display results*/
   static void display(Stack<Integer> result) {
      int size = result.size();
      String displayResult = "";
      while (!result.isEmpty()) {
         // New string = top element of stack + old string
         displayResult = String.valueOf(result.peek()) + displayResult;
         result.pop();
      }
      // Reverse print so result is showing the correct order
      System.out.println("The adding result is:");
      System.out.println("\t" + new StringBuilder(displayResult).reverse().toString());
   }
   
   /**Method to add two numbers together and return result*/
   static void addLargeNumbers(String num1, String num2) {
      // Create stacks for number1 and number2
      Stack<String> S1 = new Stack<String>();
      S1 = buildStack(num1);
      Stack<String> S2 = new Stack<String>();
      S2 = buildStack(num2);
      Stack<Integer> result = new Stack<Integer>();
      
      // Place holder for sum and remainder
      int sum = 0, rem = 0;
      
      // When both stacks are not empty
      while (!S1.isEmpty() && !S2.isEmpty()) {
         // Calculate the sum of top elements of the stacks
         sum = (rem + Integer.parseInt(S1.peek()) + Integer.parseInt(S2.peek()));
         // Push the unit digit of the sum into the result stack
         result.add(sum % 10);
         // Store the remainder to be carried
         rem = sum / 10;
   
         // Pop the top elements
         S1.pop();
         S2.pop();
    }
    
    // If S1 is not empty
    while (!S1.isEmpty()) {
      sum = (rem + Integer.parseInt(S1.peek()));
      result.add(sum % 10);
      rem = sum / 10;
      S1.pop();
    }

    // If S2 is not empty
    while (!S2.isEmpty()) {
      sum = (rem + Integer.parseInt(S2.peek()));
      result.add(sum % 10);
      rem = sum / 10;
      S2.pop();
    }
    
    // If carry remainder
    while (rem > 0) {
      result.add(rem);
      rem /= 10;
    }
    
    // Display calculated result
    display(result);
  }
}