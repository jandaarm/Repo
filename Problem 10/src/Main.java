//You are given “a” and “b”, write the function for finding
//GCD(a, b) using recursion. (Hint: Euclidean Algorithm)

import java.util.*;

public class Main{
    public static int gcd(int a, int b){
        if (b==0){
            return a;
        }
        int r = a%b;
        a=b;
        b=r;
        return gcd(a,b);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
    }
}