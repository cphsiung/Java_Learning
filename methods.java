// Chunpei Hsiung
// due date: 12/2 8:00am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Using methods to write a java program. */

import java.util.Scanner;
public class methods
{
   public static void main(String[] args) {
      // DECLARATION
      double first, second, total, subtract, multiply, divide;
      
      Greetings();
      
      // INPUT
      first = Input();
      second = Input();
            
      // PROCESS
      total = Add(first, second);
      subtract = Subtract(first, second);
      multiply = Multiply(first, second);
      divide = Divide(first, second);
      
      // OUTPUT
      Output(first, second, total, subtract, multiply, divide);
   }
   
   public static double Input() { // getting user input for numbers
      double num;
      Scanner Input = new Scanner(System.in);
      System.out.println("Please enter a number:");
      num = Input.nextDouble();
      return num;
   }
   
   public static void Greetings() { // greet user
      System.out.println("Welcome to the Java program!");
   }
   
   public static double Add(double N1, double N2) { // adding two numbers together
      return (N1 + N2);
   }
   
   public static double Subtract(double N1, double N2) { // subtracting the first from the second number
      return (N2 - N1);
   }

   public static double Multiply(double N1, double N2) { // multiply the first by the second
      return (N1 * N2);
   }

   public static double Divide(double N1, double N2) { // divide the first by the second
      return (N1 / N2);
   }

   public static void Output(double N1, double N2, double addition, double subtraction, double multiply, double divide) { // display output
      System.out.println("The numbers you entered are: " + N1 + " and " + N2);
      System.out.println(N1 + " + " + N2 + " = " + addition);
      System.out.println(N2 + " - " + N1 + " = " + subtraction);
      System.out.println(N1 + " x " + N2 + " = " + multiply);
      System.out.println(N1 + " / " + N2 + " = " + divide);
      System.out.println("\nThank you for using the program!");
   }
}