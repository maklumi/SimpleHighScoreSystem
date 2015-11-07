package com.tutsplus.code.simplehighscoresystem;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HomePC on 6/11/2015.
 */
public class HighscoreManager {
    // An arraylist of the type "score" we will use to work with the scores inside the class
    private ArrayList<Score> scores;

    // file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    //for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager() {
        scores = new ArrayList<Score>();
    }

    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }

    private void sort() {
        // ScoreComparator comparator = new ScoreComparator();
        // to sort array, use Arrays.sort(). to sort arraylist, use Collection.sort(..)
        //  Collections.sort(scores, comparator);
        Collections.sort(scores);
        //to sort according to name
        //Collections.sort(scores, Scores.namaPemainCOmparator);
    }

    public void addScore(String name, int score) {
        loadScoreFile();
        //check if same name and score no need to updatescorefile
        if (isUniqueNameandScore(name, score)) {
            scores.add(new Score(name, score));
            updateScoreFile();
        }

    }

    public void loadScoreFile() {
        //load file and put in scores arraylist
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[LoadScoreFile] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[LoadScoreFile] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[LoadScoreFile] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[LoadScoreFile] IO Error: " + e.getMessage());
            }
        }
    }

    public boolean isUniqueNameandScore(String name, int score) {
        //load array
        //check if array has name and score
        //if yes return false
        for (Score person: scores) {
            if (person.getName()== name && person.getScore() == score) {
                Log.i("nameuniqe", "not unique name score");
                return false;
            }
        }
        return true;
    }

    public void updateScoreFile() {
        // save the scores to file
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" +
                    scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }

    public int getMinNumberCanEnterTopTen() {
        int length = scores.size();
        int minEligible = 0;
        if (length > 10) {
            return scores.get(9).getScore();
        }
        return scores.get(length-1).getScore();
    }

}