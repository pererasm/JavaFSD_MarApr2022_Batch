package smPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import smPackage.Helper.PrintHelpers;
import smPackage.Modules.EvenOddModule;

public class Program {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("**********************************************************");
		System.out.println("*              Lecture 4 Items by SM Perera              *");
		System.out.println("**********************************************************");
		System.out.println("");
		
		System.out.println("Select the Module number you need to Enter");
		System.out.println("1 Even Odd Finder");
		System.out.println("2 Sum of m to n natural numbers");
		System.out.println("3 Is Prime for positive intergers");
		System.out.println("4 Factors of a number");
		System.out.println("5 Factorial of a number");
		System.out.println("6 Star Pattern");
		System.out.println("7 Number Pattern");
		
		System.out.print("? ");
		
		int input = userInput.nextInt();
		
		if (input == 1)
		{
			evenOddModule(userInput);
		}
		else if (input == 2)
		{
			sumNaturalNumbers(userInput);
		}
		else if (input == 3)
		{
			primeNumbersModule(userInput);
		}
		else if (input == 4)
		{
			factorsOfANumberModule(userInput);
		}
		else if (input == 5)
		{
			factorialOfANumberModule(userInput);
		}
		else if (input == 6)
		{
			starPatternModule(userInput);
		}
		else if (input == 7)
		{
			numberPatternModule(userInput);
		}
		else
		{
			System.out.println(PrintHelpers.expectation);
		}
		
		userInput.close();
	}

	public static void evenOddModule(Scanner userInput)
	{
		System.out.println("Do you want to enter a single number or a range");
		System.out.println("1 Single Number");
		System.out.println("2 Range");
		System.out.print("? ");
		
		int input = userInput.nextInt();
		
		if (input == 1)
		{
			System.out.println("Enter the Number.");
			EvenOddModule evenOddNumbers = new EvenOddModule(userInput.nextInt());
			
			System.out.println("\n");
			
			if (evenOddNumbers.isNumberEven())
			{
				System.out.println("Your Number is Even");
			}
			else
			{
				System.out.println("Your Number is Odd");
			}
		}
		
		else if (input == 2)
		{
			System.out.print("Enter the Start Number\n? ");
			int start = userInput.nextInt();
			System.out.print("Enter the End Number\n? ");
			EvenOddModule evenOddNumbers = new EvenOddModule(start, userInput.nextInt());
			System.out.println("\n");
			System.out.println("Even Numbers:");
			System.out.println(evenOddNumbers.getEvenNumbers());
			System.out.print("\n");
			System.out.println("Odd Numbers:");
			System.out.println(evenOddNumbers.getOddNumbers());
		}
		else
		{
			System.out.println(PrintHelpers.expectation);
		}
	}

	public static void sumNaturalNumbers(Scanner userInput)
	{
		System.out.print("Enter the start number\n? ");
		int start = userInput.nextInt();
		System.out.print("Enter the start number\n? ");
		int end = userInput.nextInt();
		
		if (start > end)
		{
			int temp = start;
			start = end;
			end = temp;
		}
		
		int sum = ((start + end) * ((end - start) + 1)) / 2; 
		
		System.out.println("Sum is " + sum);
	}
	
	public static void primeNumbersModule(Scanner userInput)
	{
		System.out.print("Enter the positive number to check if Prime\n? ");
		int number = userInput.nextInt();
		Boolean isPrime = true;
		int count = 2;
		if (!(number <= 3 && number > 0))
		{
			while(isPrime)
			{
				if (number%2==0)
				{
					isPrime = false;
					break;
				}
				
				if (number == count)
					break;
				
				if (number%count==0)
				{
					isPrime = false;
					break;
				}
				
				count++;
				
			}
		}
		
		System.out.print("The number " + number);
		if (isPrime == true)
		{
			System.out.println(" is a Prime number");
		}
		else
		{
			System.out.println(" is Not a Prime number");
		}
	}
	
	public static void factorsOfANumberModule(Scanner userInput)
	{
		System.out.println("Enter a number.");
		int input = userInput.nextInt();
		
		List<Integer> factors = new ArrayList<Integer>();
		
		for (int i=1; i<= input; i++)
		{
			if (input%i == 0)
			{
				factors.add(i);
			}
		}
		System.out.println("\n");
		System.out.println("Factors of the number " + input + " are:");
		System.out.println(factors);
	}

	private static void factorialOfANumberModule(Scanner userInput)
	{
		System.out.println("Enter a number.");
		int input = userInput.nextInt();
		long factorial = 1;
		
		for (int i=1; i<= input; i++)
		{
			factorial *= i;
		}
		System.out.println("\n");
		System.out.println("Factorial of the number " + input + " is:");
		System.out.println(factorial);
	}
	
	private static void starPatternModule(Scanner userInput)
	{
		System.out.println("Enter a number.");
		int input = userInput.nextInt();
		
		for (int i=1; i<=input; i++)
		{
			for (int j=1; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	private static void numberPatternModule(Scanner userInput)
	{
		System.out.println("Enter a number.");
		int input = userInput.nextInt();
		
		for (int i=1; i<=input; i++)
		{
			for (int j=1; j<=i; j++)
			{
				System.out.print(i);
			}
			System.out.println("");
		}
	}
}
