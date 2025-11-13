package model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Topic
{
    private String topicName;
    private ArrayList<Question> questions;
    private final static String topicDirectoryPath = "data/topics/";

    public void loadTopic(String topicName )
    {
        String topicPath = getTopicPath( topicName );
        Scanner input = null ;

        if( topicPath != null )
        {
            input = new Scanner(topicPath);
        }
        else
        {
            System.exit(0);
        }

        questions = new ArrayList<Question>();

        while ( input.hasNext() )
        {
            String line = input.nextLine();
            Question question = convertLineToQuestion( line );

            if( question != null )
            {
                questions.add( question );
            }
        }
        // return questions
    }

    private String getTopicPath( String topicName )
    {
        if( findTopicPath( topicName ) )
        {
            return topicDirectoryPath + topicName + ".txt";
        }
        else
        {
            System.err.println("Error: Topic file doesn't exist for " + topicName);
            return null;
        }
    }

    private boolean findTopicPath( String topicName )
    {
        String topicPathString = topicDirectoryPath + topicName + ".txt";
        Path topicPath = Paths.get( topicPathString );

        return Files.exists( topicPath );
    }

    private Question convertLineToQuestion( String line )
    {
        String[] data = line.split(",");
        if( data.length != 2 )
        {
            System.out.println("Invalid number of tokens to make a question.");
            return null;
        }

        return new Question( data[0], data[1] );

    }


}
