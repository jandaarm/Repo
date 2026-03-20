//You are given a number “n”, write the function for checking
//whether“n” is prime.

import java.util.Scanner;

public class Main {
    public static boolean prime(int n, int i) {
        if (i * i > n){
            return true;
        }

        if (n%i==0){
            return false;
        }

        return prime(n, i+1);
    }

    public static void main (String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();

        if (n>=2){
            boolean x = prime(n, 2);
            if (x){
                System.out.println("Prime");
            }
            else{
                System.out.println("Composite");
            }
        }

        else{
            System.out.println("Invalid input");
        }
    }
}