// Chunpei Hsiung
// due date: 11/4 8am
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Modify payroll program with loop and printf formatting */

import java.util.Scanner;
public class payroll
{
   public static void main(String[] args)
      
      {
         // Declaration
         double hour, rate, gross, tax, net;
         String firstName, lastName, idNum;
         char middleInit, repeat;
         
         Scanner Input = new Scanner(System.in);
         
         do {
            // Input
            // reset hour and rate to 0
            hour = 0;
            rate = 0;
            System.out.println("Please enter first name:");
            firstName = Input.next();
            System.out.println("Please enter middle name initial:");
            middleInit = Input.next().charAt(0);
            System.out.println("Please enter last name:");
            lastName = Input.next();
            System.out.println("Please enter ID number:");
            idNum = Input.next();
            System.out.println("Please enter hours worked:");
            // while loop to validate hours entered is greater than 0
            while (hour <= 0) {
               System.out.println("Hours must be greater than 0.");
               hour = Input.nextDouble();
            }
            // while loop to validate rates entered is greater than 0
            while (rate <= 0) {
               System.out.println("Please enter rate per hour:");
               System.out.println("Rates must be greater than 0.");
               rate = Input.nextDouble();
            }
            
            // Process
            gross = hour * rate;
            tax = gross * 0.12;
            net = gross - tax;
            
            // Output
            System.out.printf("First Name: %s\n", firstName);
            System.out.printf("Middle Initial: %s\n", middleInit);
            System.out.printf("Last Name: %s\n", lastName);
            System.out.printf("ID Number: %s\n", idNum);
            System.out.printf("Hours worked: %.1f\n", hour);
            System.out.printf("Rate per hour: $%.2f\n", rate);
            System.out.printf("Tax: $%.2f\n", tax);
            System.out.printf("Gross: $%.2f\n", gross);
            System.out.printf("Net: $%.2f\n", net);
            System.out.println("*****Thank you for using the payroll calculator!*****");
            System.out.println("Do you want to repeat? Y/N");
            repeat = Character.toLowerCase(Input.next().charAt(0));
         } while (repeat == 'y');
      }

}