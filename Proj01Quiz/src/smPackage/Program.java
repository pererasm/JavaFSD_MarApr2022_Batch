package smPackage;

import java.util.Scanner;
import smPackage.Repository.*;

public class Program {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int input = 0;
		
		System.out.println("**********************************************************");
		System.out.println("*                 QUIZ TIME by SM Perera                 *");
		System.out.println("**********************************************************");
		System.out.println("");
		
		System.out.println("Instructions: When choosing the answer, choose the choice number instead of typing the answer");
		System.out.println("[Continue, Wait]");
		System.out.print("? ");
		
		while (input != 1)
		{
			input = userInput.nextInt();
		}
		System.out.println("\n");
		
		
		IQuestionsRepository questions = new MockUpQuestionRepository();
		
		for (var question : questions.getQuestions())
		{
			System.out.println(question.getId() + ". " + question.getQuestion());
			System.out.println(question.getChoices());
			System.out.print("? ");
			question.setUserInput(userInput.nextInt());
			System.out.println("\n");
		}
		
		if (questions.getPassedSatus() == true)
		{
			System.out.println("You have Passed!!!");
		}
		else
		{
			System.out.println("You have Failed!!! Better Luck Next Time");
		}
		System.out.println("Your total is " + questions.getTotalMarks() + " of 100.0");
		
		userInput.close();
	}

}
