package DP;

import java.util.*;

public class fibonacci {
    public static void main(String args[]) {
        int n = 8;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(fibor(n));
        System.out.println(fibodp(n, dp));
        System.out.println(fiboBU(n));
        fiboSC(n);
    }

    public static int fibor(int n) {
        if (n <= 1)
            return n;
        return fibor(n - 1) + fibor(n - 2);
    }

    public static int fibodp(int n, int[] dp) {
//        TC : O(N) SC : O(N)+O(N)
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibodp(n - 1, dp) + fibodp(n - 2, dp);

    }

    public static int fiboBU(int n) {
//          TC : O(N) SC : O(N)
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void fiboSC(int n) {
//        TC : O(N) SC : O(1)
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.print(prev);
    }


}
