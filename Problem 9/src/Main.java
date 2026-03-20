//You are given  numbers “n” and “k”, write  the program that
//finds Ck(binomial coefficient) using formulaCk=Ck−1+Ck where C 0=Cn=1.

import java.util.*;

public class Main {
    public static int bc(int n, int k){
        if (k==0 || k==n){
            return 1;
        }
        int res = bc(n-1, k-1) + bc(n-1, k);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (k<0 || n<0){
            System.out.println("Values should be more that 0");
        }
        else if (k>n){
            System.out.println("k should be less than n");
        }
        else {
            System.out.println(bc(n, k));
        }
    }
}