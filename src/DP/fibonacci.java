package DP;

import java.util.*;

public class fibonacci {
    public static void main(String args[]) {
        int n = 6;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(fibor(6));
        System.out.print(fibodp(n, dp));

    }

    public static int fibor(int n) {
        if (n <= 1)
            return n;
        return fibor(n - 1) + fibor(n - 2);
    }

    public static int fibodp(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return fibodp(n - 1, dp) + fibodp(n - 2, dp);

    }

}
