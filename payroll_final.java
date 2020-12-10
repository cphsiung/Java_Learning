// Chunpei Hsiung
// due date: 12/11 11:59pm
// Prof. Aljamal
// Java Programming CSC-117-01
/* program description
   Write a Java program to create a payroll report based on the assumptions and requirements. */

import java.util.Scanner;

public class payroll_final
{
   public static void main(String[] args)
   {
      // DECLARATION
      double stateTaxRate = 0.06, fedTaxRate = 0.12, unionFeeRate = 0.01, overtimeRate = 0.5; // constants for tax & fee rates
      double total = 0, avg = 0; // store calculated gross pay and average pay for all employees
      final int size = 2; // size for arrays
      String [] firstName = new String [size];
      String [] lastName = new String [size];
      char [] middleInit = new char [size];
      double [] rates = new double [size];
      double [] hours = new double [size];
      double [] stateTax = new double [size];
      double [] fedTax = new double [size];
      double [] unionFee = new double [size];
      double [] netPay = new double [size];
      double [] grossPay = new double [size]; 
      double [] overtime = new double [size];
      
      Scanner Input = new Scanner(System.in);
      
      dataInput(firstName, middleInit, lastName, rates, hours, size, Input);
      Overtime(rates, hours, overtime, size, overtimeRate);
      GrossPay(grossPay, hours, rates, overtime, size);
      State(stateTax, grossPay, size, stateTaxRate);
      Federal(fedTax, grossPay, size, fedTaxRate);
      Union(unionFee, grossPay, size, unionFeeRate);
      Net(netPay, grossPay, stateTax, fedTax, unionFee, size);
      Summary(total, grossPay, size);
      Average(avg, total, size);
      
      System.out.printf("%-13s", firstName[0]);
      System.out.printf("%-4C", middleInit[0]); // capital C to format to capital letter
      System.out.printf("%-13s", lastName[0]);
      System.out.printf("$%,-10.2f", rates[0]);
      System.out.printf("%-8.0f", hours[0]);
      System.out.printf("%-8.0f", overtime[0]);
      System.out.printf("%-8.0f", grossPay[0]);
      System.out.printf("%-8.0f", stateTax[0]);
   }

   // INPUT
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
     
   public static double rateValidation(double var, Scanner KB) // validate rates between 15 - 50
   { 
      while(var < 15 || var > 50) {
         System.out.println("Rates must be between 15 and 50. Please re-enter:");
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
   public static void Summary(double total, double grossPay[], final int size)
   {
      for (int ct = 0; ct < size; ct++) {
         total += grossPay[ct];
      }
   }  

   // Calculate average pay for all employees
   public static double Average(double avg, double total, int size)
   {
      avg = total/size;
   }


   public static void Output()
   {
      
   }
/*          
            
         for (int i = 0; i < size; i++) {
            System.out.println("Please enter first name for employee" + (i + 1) + " :"); // i + 1 to get employee count
            firstName[i] = Input.next();
            System.out.println("Please enter middle name initial for employee" + (i + 1) + " :");
            middleInit[i] = Input.next().charAt(0);
            System.out.println("Please enter last name for employee" + (i + 1) + " :");
            lastName[i] = Input.next();
            System.out.println("Please enter employee" + (i + 1) + " pay rates per hour:");
            rates[i] = Input.nextDouble();
            while (rates[i] < 15 || rates[i] > 50) {
               System.out.println("Rates must be between 15 to 50.");
               rates[i] = Input.nextDouble();
            } // while loop for data validation
            System.out.println("Please enter hours worked for employee" + (i + 1) + " :");
            hours[i] = Input.nextDouble();
            while (hours[i] < 0 || hours[i] > 60) {
               System.out.println("Hours must be between 0 to 60.");
               hours[i] = Input.nextDouble();
            }
         }
              
         // PROCESS
         for (int k = 0; k < size; k++) {
            // Calculate additional overtime pay
            if (hours[k] > 40) {
               overtime[k] = (hours[k] - 40) * rates[k] * overtimeRate;
            } else {
               overtime[k] = 0;
            }
            // Calculate gross pay
            grossPay[k] = hours[k] * rates[k] + overtime[k];
            // Calculate State Tax amount
            stateTax[k] = grossPay[k] * stateTaxRate;
            // Calculate Federal Tax amount
            fedTax[k] = grossPay[k] * fedTaxRate;
            // Calculate Union Fees
            unionFee[k] = grossPay[k] * unionFeeRate;
            // Calculate net pay
            netPay[k] = grossPay[k] - (stateTax[k] + fedTax[k] + unionFee[k]);
         }
          
         // Calculate gross pay for all employees
         for (int ct = 0; ct < size; ct++) {
            total += grossPay[ct];
         }
         // Calculate average pay for all employees
         avg = total/size;
         
         // OUTPUT
         System.out.println("                         Data Housing Corp. Payroll");
         System.out.println("                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.printf("%-12s %-3s %-11s %-10s %-8s %-10s %-10s %-10s %-12s %-10s\n", 
                           "First Name", "MI", "Last Name", "Rate/Hour", "Hours", "Gross", "State Tax", "Fed Tax", "Union Fees", "Net");

         for (int j = 0; j < size; j++) {
            System.out.printf("%-13s", firstName[j]);
            System.out.printf("%-4C", middleInit[j]); // capital C to format to capital letter
            System.out.printf("%-13s", lastName[j]);
            System.out.printf("$%,-10.2f", rates[j]);
            System.out.printf("%-8.0f", hours[j]);
            System.out.printf("$%,-10.2f", grossPay[j]);
            System.out.printf("$%,-10.2f", stateTax[j]);
            System.out.printf("$%,-10.2f", fedTax[j]);
            System.out.printf("$%,-12.2f", unionFee[j]);
            System.out.printf("$%,-10.2f\n", netPay[j]);
         }
         
         System.out.print("\nGross Pay for all employees\t: ");
         System.out.printf("$%,.2f", total);
         System.out.print("\nAverage Pay for all employees\t: ");
         System.out.printf("$%,.2f", avg);
      }
*/
}
