package model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String username;
    private int numTimesPlayed;
    private int totalAttempts;
    private final static String playerDataFilePath = "data/player-data.txt";

    public Player(String username, int numTimesPlayed, int totalAttempts)
    {
        this.username = username;
        this.numTimesPlayed = numTimesPlayed;
        this.totalAttempts = totalAttempts;
    }

    public static ArrayList<Player> loadPlayerData() throws FileNotFoundException
    {
            File data = new File(playerDataFilePath);
            Scanner input = new Scanner(data);
            ArrayList<Player> players = new ArrayList<>();

            while ( input.hasNext() )
            {
                String line = input.nextLine();
                Player player = convertLineToPlayer( line );

                if( player != null )
                {
                    players.add( player );
                }
            }
            return players;
    }

    public static Player findPlayer(String username, ArrayList<Player> players) throws FileNotFoundException
    {
        for( Player player : players )
        {
            if( player.getUsername().equals( username ) )
            {
                return player;
            }
        }
        return null;
    }

    private static Player convertLineToPlayer(String line)
    {
        String[] data = line.split(",");
        if( data.length != 3 )
        {
            System.out.println("Invalid number of tokens to make a player.");
            return null;
        }

        return new Player( data[0], Integer.parseInt( data[1] ),
                            Integer.parseInt( data[2] ) );
    }

    public static void savePlayerData(ArrayList<Player> players) throws IOException
    {
        FileWriter fw = new FileWriter( playerDataFilePath );
        BufferedWriter bw = new BufferedWriter( fw );

        for( Player player : players )
        {
            bw.write( convertPlayerToLine( player, "," ) );
            bw.write( "\n" );
        }
        bw.close();

    }

    public double getAverageNumberAttempts()
    {
        return (double) totalAttempts / numTimesPlayed;
    }
    private static String convertPlayerToLine(Player player, String separator)
    {
        return player.getUsername() + separator +
                player.getNumTimesPlayed() + separator +
                player.getTotalAttempts();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getNumTimesPlayed() {
        return numTimesPlayed;
    }

    public void setNumTimesPlayed(int numTimesPlayed)
    {
        this.numTimesPlayed = numTimesPlayed;
    }

    public int getTotalAttempts()
    {
        return totalAttempts;
    }

    public void setTotalAttempts(int totalAttempts)
    {
        this.totalAttempts = totalAttempts;
    }
}
