package smPackage.Repository;

import java.util.List;

import smPackage.Models.Question;

public interface IQuestionsRepository {
	public List<Question> getQuestions();
	public Question getQuestionById(int id);
	public Question addQuestion(Question question);
	public Question removeQuestionById(int id);
	public Question editQuestionById(int id);
	public Boolean getPassedSatus();
	public float getTotalMarks();
}
