//You are given a number “n”, write the program using recursion for
//finding “n!”

import java.util.Scanner;

public class Main{
    public static long factorial(int n){
        if (n == 1 || n==0){
            return 1;
        }
        return factorial(n-1) * n;
    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();

        if (n>=0){
            System.out.println(n + "! = " + factorial(n));
        }

        else{
            System.out.println("Invalid input");
        }
    }
}