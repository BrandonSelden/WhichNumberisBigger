package com.example.whichnumberisbigger;

public class BiggerNumberGame  {
    private int number1;
    private int number2;
    private int score;
    private int lowLim;
    private int hiLim;

    public BiggerNumberGame(int lowLim, int hiLim) {
        this.lowLim = lowLim;
        this.hiLim = hiLim;
        generateRandomNumbers();
    }

    public void generateRandomNumbers(){
        //generate number between uppr n lower limits inclusive.
        //store in number1
        //generate other number and store in number2
        number1 = (int)(Math.random() * hiLim - lowLim + 1) + lowLim;
        number2 = (int)(Math.random() * hiLim - lowLim + 1) + lowLim;
        while(number1 == number2){
            number2 = (int)(Math.random() * hiLim - lowLim + 1) + lowLim;
        }
    }

    public String checkAnswer(int answer){
        //determine if answer is correct, and update score, and return message
        if(isRight(answer))
        {
            return "YOU DID IT!";
        }
        return "BOO! TRY AGAIN!";
    }

    public boolean isRight(int answer)
    {
        if(answer == (Math.max(number1, number2))){
            score++;
            return true;
        }
        score--;
        return false;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLowLim() {
        return lowLim;
    }

    public void setLowLim(int lowLim) {
        this.lowLim = lowLim;
    }

    public int getHiLim() {
        return hiLim;
    }

    public void setHiLim(int hiLim) {
        this.hiLim = hiLim;
    }
}
