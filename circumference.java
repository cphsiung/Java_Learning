// Chunpei Hsiung
// due date 10/12 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a java program to calculate the circumference for the triangle and the square shapes  */

import java.util.Scanner;

public class circumference
{
   public static void main(String[] args)
      
      {
         // Declaration
         String choice;
         String triangle1 = "", triangle2 = "", triangle3 = "", squareside = ""; // sides
         int triangle = 0, square = 0; // circumference
         int inttri1 = 0, inttri2 = 0, inttri3 = 0, intsquare = 0; // convert string input to integer
         
         // Input
         choice = JOptionPane.showInputDialog("Calculate circumference for a Triangle?  Enter 1\n" +
                                              "Calculate circumference for a Square?    Enter 2");
         
        if (choice.contentEquals("1"))
            {
               triangle1 = JOptionPane.showInputDialog("Ok, a Triangle.\nPlease enter the first side:");
               triangle2 = JOptionPane.showInputDialog("Please enter the second side:");
               triangle3 = JOptionPane.showInputDialog("Please enter the third side:");
            }
         else if (choice.contentEquals("2"))
            {
               squareside = JOptionPane.showInputDialog("Ok, a Square.\nPlease enter the square side:");
            }
         else
            {
               JOptionPane.showMessageDialog(null,"Invalid choice, please try again.");
               System.exit(0);
            }
         
         // Process
         if (choice.contentEquals("1"))
            {
               inttri1 = Integer.parseInt(triangle1);
               inttri2 = Integer.parseInt(triangle2);
               inttri3 = Integer.parseInt(triangle3);
               triangle = inttri1 + inttri2 + inttri3;
            }
         else
            {
               intsquare = Integer.parseInt(squareside);
               square = intsquare * 4;
            }
         
         // Output
         if (choice.contentEquals("1"))
            {
               System.out.print("Triangle\n" + 
                                "\t\t\tSide 1 = " + triangle1 + ", \t" + "Side 2 = " + triangle2 + ", \t" + "Side 3 = " + triangle3 +
                                "\n\t\t\tCircumference = " + triangle);
            }
         else
            {
               System.out.print("Square\n" + 
                                  "\t\t\tSide = " + squareside +
                                  "\n\t\t\tCircumference = " + square);

            }

      }

}