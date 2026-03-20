//You are given numbers “a” and “n”, write the function that
//returns “a^n”.

import java.util.Scanner;

public class Main{
    public static int exp(int a, int n){
        if (n==0){
            return 1;
        }
        return exp(a, n-1) * a;
    }

    public static void main(String[] args){
        int n;
        int a;
        Scanner sc = new Scanner(System.in);

        System.out.print("a = ");
        a = sc.nextInt();

        System.out.print("n = ");
        n = sc.nextInt();

        if (n>=0){
            System.out.println(a + "^" + n + " = " + exp(a, n));
        }
        else {
            n = -n;
            System.out.println(a + "^-" + n + " = " + 1.00/exp(a, n));
        }
    }
}