//You are given a number “n”, write the function for finding n-th
//elements in Fibonacci sequence using recursion. (Fn = Fn-1+ Fn-2).
//F0= 0, F1 = 1.

import java.util.Scanner;

public class Main{
    public static long fib(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();

        if (n>=0){
            System.out.println("n'th term is " + fib(n));
        }

        else{
            System.out.println("Invalid input");
        }
    }
}