package model;

public class Settings
{
    private int numQuestions;
    private String topicName;
    private int maxAttemptsPerQuestion;

    public Settings( int numQuestions, String topicName, int maxAttemptsPerQuestion )
    {
        this.numQuestions = numQuestions;
        this.topicName = topicName;
        this.maxAttemptsPerQuestion = maxAttemptsPerQuestion;
    }

    public int getNumQuestions()
    {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions)
    {
        this.numQuestions = numQuestions;
    }

    public String getTopicName()
    {
        return topicName;
    }

    public void setTopicName(String topicName)
    {
        this.topicName = topicName;
    }

    public int getMaxAttemptsPerQuestion()
    {
        return maxAttemptsPerQuestion;
    }

    public void setMaxAttemptsPerQuestion(int maxAttemptsPerQuestion)
    {
        this.maxAttemptsPerQuestion = maxAttemptsPerQuestion;
    }
}
