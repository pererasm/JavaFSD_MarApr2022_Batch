package smPackage.Models;

import java.util.ArrayList;
import java.util.List;

public class Question
{
	private int id;
	private String question;
	private List<String> choices = new ArrayList<String>();
	private int answer;
	private int userInput;
	private int markWeight = 10;
	
	public Question(int id)
	{
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getMarkWeight() {
		return markWeight;
	}

	public void setMarkWeight(int markWeight) {
		this.markWeight = markWeight;
	}
	
	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}
	
	public int getUserInput()
	{
		return userInput;
	}
	
	public int getMarks()
	{
		if (getAnswer() == getUserInput())
		{
			return getMarkWeight();
		}
		return 0;
	}
}
