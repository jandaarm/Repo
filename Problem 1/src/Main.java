//You are given a number “n” and an array of “n” elements,
//write the function that returns minimum of them.

import java.io.*;
import java.util.*;

public class Main {
    public static int minimal(int[] arr, int n){
        if (n==1){
            return arr[0];
        }
        int minOfRest = minimal(arr, n-1);
        return Math.min(arr[n-1], minOfRest);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("List the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minimal(arr, n));
    }
}