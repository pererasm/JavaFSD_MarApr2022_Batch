package smPackage.Repository;

import java.util.ArrayList;
import java.util.List;

import smPackage.Models.Question;

public class MockUpQuestionRepository implements IQuestionsRepository
{
	private int totalMarkWeight = 0;
	
	private int totalQuestions;
	
	private float passMarkPercentage = 75f;
	
	public MockUpQuestionRepository()
	{
		generateQuestions();
		
		this.totalQuestions = QuestionsDB.size();
		
		for (var question : QuestionsDB)
		{
			this.totalMarkWeight += question.getMarkWeight();
		}
	}

	@Override
	public List<Question> getQuestions() {
		// TODO Auto-generated method stub
		return QuestionsDB;
	}

	@Override
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		for (var question : QuestionsDB)
		{
			if (question.getId() == id)
				return question;
		}
		return new Question(0);
	}

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question removeQuestionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question editQuestionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public int getTotalMarkWeight() {
		return totalMarkWeight;
	}
	
	public float getTotalMarks()
	{
		int totalCorrectMarks = 0, totalMarks = 0;
		for (var question : getQuestions())
		{
			totalCorrectMarks += question.getMarks();
			totalMarks += question.getMarkWeight();
		}
		return totalCorrectMarks / totalMarks * 100;
	}
	
	public void setPassedMarkPercentage(float passMarkPercentage)
	{
		this.passMarkPercentage = passMarkPercentage;
	}
	
	public float getPassedMarkPercentage()
	{
		return passMarkPercentage;
	}
	
	public Boolean getPassedSatus()
	{
		if (getTotalMarks() >= getPassedMarkPercentage())
		{
			return true;
		}
		return false;
	}
	
	private List<Question> QuestionsDB = new ArrayList<Question>();
	
	private void generateQuestions()
	{
		var question = new Question(1);
		var choices = new ArrayList<String>();
		question.setQuestion("If there are 30 question in the quiz, what is the progression for each WRONG answer provided?");
		
		choices.add("0.00%");
		choices.add("3.33%");
		choices.add("10.00%");
		choices.add("6.66%");
		
		question.setChoices(choices);
		
		question.setAnswer(2);
		
		this.QuestionsDB.add(question);
		
		question = new Question(1);
		choices = new ArrayList<String>();
		question.setQuestion("If 3 people get in a to taxi. On the journey, police stopped the car and requests for everyone to get out. How many people got out?");
		
		choices.add("1");
		choices.add("2");
		choices.add("3");
		choices.add("4");
		
		question.setChoices(choices);
		
		question.setAnswer(4);
		
		this.QuestionsDB.add(question);
	}
}
