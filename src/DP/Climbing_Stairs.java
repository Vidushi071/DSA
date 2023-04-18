package DP;

import java.util.Arrays;

//Print the no of ways one can climb the stairs by taking either 1 step or two step at most
public class Climbing_Stairs {

    public static void main(String args[]) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(noOfSteps(n));
        System.out.println(TD(n, dp));
    }

    public static int noOfSteps(int stairs) {
        if (stairs == 0 || stairs == 1)
            return 1;
        int left = noOfSteps(stairs - 1);
        int right = noOfSteps(stairs - 2);
        return left + right;
    }

    public static int TD(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = TD(n - 1, dp) + TD(n - 2, dp);
    }
}
