// Chunpei Hsiung
// due date 10/26 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a java program to calculate the area of four shapes  */

import java.util.Scanner;

public class area
{
   // method for validating once if entry is greater than 0
   public static double validator (double n) {
      Scanner Input = new Scanner(System.in);
      if (n <= 0) {
         System.out.println("Please enter a number greater than 0!");
         n = Input.nextDouble();
       }
      return n;
   }
   
   public static void main(String[] args)
      
      {
         // Declaration
         int choice; 
         double userentry, rectangle = 0, length = 0, width = 0, triangle = 0, base = 0, height = 0, circle = 0, radius = 0, square = 0, side = 0;
         Scanner Input = new Scanner(System.in);      
         
         // Input
         System.out.println("Welcome to shape area calculator! Please choose shape you want to calculate:\n\tRectangle - enter 1\n\tTriangle - enter 2\n\tCircle - enter 3\n\tSquare - enter 4");
         choice = Input.nextInt();

         switch (choice) {
            case 1:  // Rectangle
                     System.out.println("Rectangle! Please enter length:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry); // validate if entry greater than 0
                     length = userentry; // store user entry to length
                     System.out.println("Please enter width:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry);
                     width = userentry;
                     break;
            case 2:  // Triangle
                     System.out.println("Triangle! Please enter base:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry);
                     base = userentry;
                     System.out.println("Please enter height:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry);
                     height = userentry;         
                     break;
            case 3:  // Circle
                     System.out.println("Circle! Please enter radius:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry);
                     radius = userentry;
                     break;
            case 4:  // Square
                     System.out.println("Square! Please enter side:");
                     userentry = Input.nextDouble();
                     userentry = validator(userentry);
                     side = userentry;
                     break;
            default: // all other choices
                     System.out.println("Invalid choice, please try again.");
                     break;
            }
            
         // Process
         rectangle = length * width;
         triangle = (base * height)/2;
         circle = 3.14 * radius * radius;
         square = side * side;
         
         // Output
         switch (choice) {
            case 1:
               System.out.println("Rectangle\n length = " + length + " width = " + width + "\n area = " + rectangle);
               break;
            case 2:
               System.out.println("Triangle\n base = " + base + " height = " + height + "\n area = " + triangle);
               break;
            case 3:
               System.out.println("Circle\n radius = " + radius + "\n area = " + circle);
               break;
            case 4:
               System.out.println("Square\n side = " + side + "\n area = " + square);
               break;
         }
      }

}