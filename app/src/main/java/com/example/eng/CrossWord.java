package com.example.eng;

public class CrossWord {
    public String tasks[] = {"A place where very sick people are taken(8 букв)",
            "A place where people bathe and wash clothing(8 букв)",
            "A group of people who fight to protect their country(4 буквы)",
            "It is an animal. It moves very slowly(8 букв)",
            "Twelve months(4 буквы)",
            "“How old are you?” what it means(3 буквы)",
            "When people cry, they flow from their eyes(4 буквы)"
    };
    private String correctAnswer[]={"hospital","bathroom", "army", "tortoise", "year", "age", "tear"};

    public String getTask(int a){
        String task = tasks[a];
        return task;
    }
    public String getAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}

