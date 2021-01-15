// Chunpei Hsiung
// due date: 12/11 11:59pm
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a Java program to create a payroll report based on the assumptions and requirements. */

import java.util.Scanner;

public class testQ1
{
   public static void main(String[] args)
   {
         // DECLARATION
         final int size = 10; // size for arrays
         int [] Arr = new int [size];
         
         Scanner Input = new Scanner(System.in);
         
         // INPUT & PROCESS         
         dataInput(firstName, middleInit, lastName, rates, hours, size, Input);
         Overtime(rates, hours, overtime, size, overtimeRate);
         GrossPay(grossPay, hours, rates, overtime, size);
         State(stateTax, grossPay, size, stateTaxRate);
         Federal(fedTax, grossPay, size, fedTaxRate);
         Union(unionFee, grossPay, size, unionFeeRate);
         Net(netPay, grossPay, stateTax, fedTax, unionFee, size);
         total = Summary(total, grossPay, size);
         avg = Average(avg, total, size);
         
         // OUTPUT
         Output(firstName, middleInit, lastName, rates, hours, grossPay, stateTax, fedTax, unionFee, netPay, size, total, avg);
         repeat = Ending(repeat, Input);
      } while (repeat == 'y');
   }

   public static void dataInput(String first[], char middle[], String last[], double rates[], double hours[], final int size, Scanner Input)
   {
      for (int i = 0; i < size; i++) {
         System.out.println("Please enter first name for employee" + (i + 1) + " :"); // i + 1 to get employee count
         first[i] = Input.next();
         System.out.println("Please enter middle name initial for employee" + (i + 1) + " :");
         middle[i] = Input.next().charAt(0);
         System.out.println("Please enter last name for employee" + (i + 1) + " :");
         last[i] = Input.next();
         System.out.println("Please enter employee" + (i + 1) + " pay rates per hour:");
         rates[i] = Input.nextDouble();
         rateValidation(rates[i], Input);
         System.out.println("Please enter hours worked for employee" + (i + 1) + " :");
         hours[i] = Input.nextDouble();
         hourValidation(hours[i], Input);
      }
   }
     
   public static double rateValidation(double var, Scanner KB) // validate rates > 0
   { 
      while(var < 0) {
         System.out.println("Rates must be greater than 0. Please re-enter:");
         var = KB.nextDouble();
      }
      return var;
   }

   public static double hourValidation(double var, Scanner KB) // validate hours between 0 - 60
   { 
      while(var < 0 || var > 60) {
         System.out.println("Hours must be between 0 and 60. Please re-enter:");
         var = KB.nextDouble();
      }
      return var;
   }
   
   // Calculate additional overtime pay
   public static void Overtime(double rates[], double hours[], double overtime[], final int size, double overtimeRate) 
   {
      for (int k = 0; k < size; k++) {
         if (hours[k] > 40) {
            overtime[k] = (hours[k] - 40) * rates[k] * overtimeRate;
         } else {
            overtime[k] = 0;
         }
      }
   }
   
   // Calculate gross pay
   public static void GrossPay(double grossPay[], double hours[], double rates[], double overtime[], final int size)
   {
      for (int k = 0; k < size; k++) {
         grossPay[k] = hours[k] * rates[k] + overtime[k];
      }
   }         

   // Calculate state tax
   public static void State(double stateTax[], double grossPay[], final int size, double stateTaxRate)
   {
      for (int k = 0; k < size; k++) {
         stateTax[k] = grossPay[k] * stateTaxRate;
      }
   }

   // Calculate Federal tax
   public static void Federal(double fedTax[], double grossPay[], final int size, double fedTaxRate)
   {
      for (int k = 0; k < size; k++) {
         fedTax[k] = grossPay[k] * fedTaxRate;
      }
   }

   // Calculate union fee amount
   public static void Union(double unionFee[], double grossPay[], final int size, double unionFeeRate)
   {
      for (int k = 0; k < size; k++) {
         unionFee[k] = grossPay[k] * unionFeeRate;
      }
   }

   // Calculate net pay amount
   public static void Net(double netPay[], double grossPay[], double stateTax[], double fedTax[], double unionFee[], final int size)
   {
      for (int k = 0; k < size; k++) {
         netPay[k] = grossPay[k] - (stateTax[k] + fedTax[k] + unionFee[k]);
      }
   }

   // Calculate total gross pay for all employees
   public static double Summary(double total, double grossPay[], final int size)
   {
      for (int ct = 0; ct < size; ct++) {
         total += grossPay[ct];
      }
      return total;
   }  

   // Calculate average pay for all employees
   public static double Average(double avg, double total, int size)
   {
      avg = total/size;
      return avg;
   }

   // Output method
   public static void Output(String firstName[], char middleInit[], String lastName[], double rates[], double hours[], double grossPay[], double stateTax[], double fedTax[], double unionFee[], double netPay[], final int size, double total, double avg) throws IOException
   {
         PrintWriter Streem = new PrintWriter("Payroll.txt");
         Streem.println("                                        Data Housing Corp. Payroll");
         Streem.println("=======================================================================================================");
         Streem.printf("%-12s %-3s %-11s %-10s %-8s %-10s %-10s %-10s %-12s %-10s\n", 
                           "First Name", "MI", "Last Name", "Rate/Hour", "Hours", "Gross", "State Tax", "Fed Tax", "Union Fees", "Net");

         for (int j = 0; j < size; j++) {
            Streem.printf("%-13s", firstName[j]);
            Streem.printf("%-4C", middleInit[j]); // capital C to format to capital letter
            Streem.printf("%-13s", lastName[j]);
            Streem.printf("$%,-10.2f", rates[j]);
            Streem.printf("%-8.0f", hours[j]);
            Streem.printf("$%,-10.2f", grossPay[j]);
            Streem.printf("$%,-10.2f", stateTax[j]);
            Streem.printf("$%,-10.2f", fedTax[j]);
            Streem.printf("$%,-12.2f", unionFee[j]);
            Streem.printf("$%,-10.2f\n", netPay[j]);
         }
         
         Streem.print("\nGross Pay for all employees\t: ");
         Streem.printf("$%,.2f", total);
         Streem.print("\nAverage Pay for all employees\t: ");
         Streem.printf("$%,.2f", avg);
         Streem.close();
   }
   
   public static char Ending(char var, Scanner Input)
   {
      System.out.println("Thank you for using the program!");
      System.out.println("Do you want to repeat? y/n");
      var = Character.toLowerCase(Input.next().charAt(0));
      if (var == 'n') {
         System.out.println("Thank you! See you next time!");
      }
      return var;
   }
}
