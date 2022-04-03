package smPackage.Repository;

import java.util.ArrayList;
import java.util.List;

import smPackage.Models.Question;

public class MockUpQuestionRepository implements IQuestionsRepository
{
	public MockUpQuestionRepository()
	{
		generateQuestions();
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