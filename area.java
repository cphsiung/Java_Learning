// Chunpei Hsiung
// due date 10/26 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a java program to calculate the area of four shapes  */

import java.util.Scanner;

public class area
{
   public static int validator (int n) {
      Scanner Input = new Scanner(System.in);
      if (n <= 0) {
         System.out.println("Please enter a number greater than 0!");
         n = Input.nextInt();
       }
      return n;
   }
   
   public static void main(String[] args)
      
      {
         // Declaration
         int choice, userentry, rectangle, length, width, triangle, base, height, circle, radius, square, side;
         boolean startloop = true;
         Scanner Input = new Scanner(System.in);      
         
         // Input
         while(startloop) {
            System.out.println("Welcome to shape area calculator! Please choose shape you want to calculate:\n\tRectangle - enter 1\n\tTriangle - enter 2\n\tCircle - enter 3\n\tSquare - enter 4");
            choice = Input.nextInt();
   
            switch (choice) {
               case 1:  System.out.println("Rectangle! Please enter length:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        length = userentry;
                        System.out.println("Please enter width:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        width = userentry;
                        startloop = false;
                        break;
               case 2:  System.out.println("Triangle! Please enter base:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        base = userentry;
                        System.out.println("Please enter height:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        height = userentry;         
                        startloop = false;
                        break;
               case 3:  System.out.println("Circle! Please enter radius:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        radius = userentry;
                        startloop = false;
                        break;
               case 4:  System.out.println("Square! Please enter side:");
                        userentry = Input.nextInt();
                        userentry = validator(userentry);
                        side = userentry;
                        startloop = false;
                        break;
               default: System.out.println("Invalid choice, please try again.");
            }
         }
         // Process
         rectangle = length * width;
         triangle = (base * height)/2;
         circle = 3.14 * radius * radius;
         square = side * side;
         
         // Output
         switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
         }
      }

}