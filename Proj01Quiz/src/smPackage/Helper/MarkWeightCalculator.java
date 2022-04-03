package smPackage.Helper;

import java.util.List;

import smPackage.Models.Question;

public class MarkWeightCalculator
{
	private int totalMarkWeight = 0;
	
	private int totalQuestions;
	
	public MarkWeightCalculator(List<Question> questions)
	{
		this.totalQuestions = questions.size();
		
		for (var question : questions)
		{
			this.totalMarkWeight += question.getMarkWeight();
		}
		
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public int getTotalMarkWeight() {
		return totalMarkWeight;
	}
}
