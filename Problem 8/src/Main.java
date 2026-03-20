//You are given a string “s”, write the function for checking
//whether “s” is all consists of digits.

import java.util.*;

public class Main {

    public static boolean isDigit(String s) {
        int m = s.length();
        if (m == 0) {
            return true;
        }
        char c = s.charAt(m - 1);
        boolean d = Character.isDigit(c);
        if (!d) {
            return false;
        }
        String rem = s.substring(0, m - 1);
        return isDigit(rem);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean res = isDigit(s);
        if (res){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
}