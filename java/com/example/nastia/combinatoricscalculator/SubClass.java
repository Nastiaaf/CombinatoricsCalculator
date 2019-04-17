package com.example.nastia.combinatoricscalculator;

public class SubClass {
    private long amountNum;
    private long timesNum;
    private long numerator;
    public long denom;
    //No repetitions constructor
    SubClass (String amount, String times){
        amountNum= Long.parseLong(amount);
        timesNum=Long.parseLong(times);
    }
    //Factorial calculation
    private long Factorial(long num){
        if (num==0)
            return 1;
        else{
            return num*Factorial(num-1);
        }
    }
    //Calculate substitutions without repetitions
    public String SubsNoRep(){
        numerator=Factorial(amountNum);
        denom=Factorial(amountNum-timesNum);
        return Long.toString(numerator/denom);
    }
    //Calculate substitutions with repetitions
    public String SubsRep(){
        return Long.toString((long)(Math.pow(amountNum,timesNum)));
    }
}
