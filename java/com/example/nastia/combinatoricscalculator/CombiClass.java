package com.example.nastia.combinatoricscalculator;

public class CombiClass {
    private long n;
    private long k;
    private long numerator;
    private long denom;
    //Constructor
    CombiClass(String nStr,String kStr){
        n=Long.parseLong(nStr);
        k=Long.parseLong(kStr);
    }
    //Factorial calculation
    private long Factorial(long num){
        if (num==0)
            return 1;
        else{
            return num*Factorial(num-1);
        }
    }
    //Calculate binomial coefficient
    private long BinomialC(long n, long k){
        numerator=Factorial(n);
        denom=Factorial(n-k)*Factorial(k);
        return numerator/denom;
    }
    //Calculate combinations with repetitions
    public String combiRep(){
        return Long.toString(BinomialC(n+k-1,k));
    }
    //Calculate combinations without repetitions
    public String combiNoRep(){
        return Long.toString(BinomialC(n,k));
    }
}
