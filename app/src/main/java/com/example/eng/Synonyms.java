package com.example.eng;

public class Synonyms {
    public String word[] = {"Amazing", "Anger", "Dangerous", "Go", "Keep"};
    private String choices[][] = {
            {"fabulous", "inappropriate"},
            {"lovely","madden"},
            {"risky","chilly"},
            {"move","earn"},
            {"contain","hold"}
    };
    private String correctAnswer[]={"fabulous","madden","risky","move","hold"};

    public String getWord(int a){
        String gWord = word[a];
        return gWord;
    }
    public String getChoice1(int a){
        String choice = choices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = choices[a][1];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String corrAnswer = correctAnswer[a];
        return corrAnswer;
    }
}
