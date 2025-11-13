package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    private Settings settings;
    private ArrayList<Player> players;
    private Player player;
    private ArrayList<Question> questions;
    private Question currentQuestion;
    private int sessionAttempts;
    private int sessionCorrectGuesses;
    private int sessionQuestionsAsked;

    public void loadGame(String username) throws FileNotFoundException {

        this.players = Player.loadPlayerData();
        this.player = Player.findPlayer( username, players );

        questions = Topic.loadTopic("");
    }

    public void startGame()
    {
        Collections.shuffle(questions);
        currentQuestion = questions.removeFirst();
        sessionAttempts = 0;
        sessionCorrectGuesses = 0;
        sessionQuestionsAsked = 0;
    }

    public void submitAnswer(String answer)
    {
        if ( answer.equals(currentQuestion.getAnswer()) )
        {
            sessionCorrectGuesses++;
        }
        sessionAttempts++;
    }

    public void getNextQuestion()
    {
        currentQuestion = questions.removeFirst();
        sessionQuestionsAsked++;
    }

    public void endSession()
    {

    }

    private void saveGame() throws IOException
    {
        Player.savePlayerData( players );
    }
}
