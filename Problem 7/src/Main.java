//You are given a string consisting of M distinct symbols. Print
//all the permutations (all possible variants) of the symbols of this
//string.
import java.util.Scanner;

public class Main {

    public static void perm(String res, String rem) {
        int m = rem.length();
        if(m==0){
            System.out.println(res);
            return;
        }

        for (int i = 0; i < rem.length(); i++){
            char c = rem.charAt(i);
            String newRes = res + c;
            String newRem = rem.substring(0, i) + rem.substring(i + 1);
            perm(newRes, newRem);
        }

    }

    public static void main(String[] args) {
        String rem;
        Scanner sc = new Scanner(System.in);
        rem = sc.nextLine();
        perm("", rem);
    }
}