package com.example.nastia.combinatoricscalculator;

import java.util.ArrayList;

public class PerClass {
    private long n;
    private long factRes=1;
    private int i;
    private ArrayList<Long> nums = new ArrayList<Long>();
    private long sum;
    private long numerator;
    private long denom;
    //Constructor for non repetition
    PerClass(String objNum){
        //Convert string to long int
        n=Long.parseLong(objNum);
        if (n<0){
            //throw an exception
        }
    }
    //Constructor for repetition
    PerClass(ArrayList<String> arr){
        for (i=0;i<arr.size();i++)
        {
            nums.add(Long.parseLong(arr.get(i)));
        }
    }
    //Factorial calculation
    private long Factorial(long num){
        if (num==0)
            return 1;
        else{
            return num*Factorial(num-1);
        }
    }
    //Get permutations without repetition
    public String PerNoRep(){
        return Long.toString(Factorial(n));
    }
    //Get permutations with repetition
    public String PerRep(){
        sum=0;
        denom=1;
        //Summing values for the numerator
        for (i=0;i<nums.size();i++)
        {
            sum+=nums.get(i);
        }
        numerator=Factorial(sum);
        for (i=0;i<nums.size();i++)
        {
            denom*=Factorial(nums.get(i));
        }
        return Long.toString(numerator/denom);
    }
}
