package DP;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String args[]) {
        int arr[] = {30, 20, 60};
        int wt[] = {3, 2, 5};
        int w = 8;
        int[][] dp = new int[arr.length][w + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(func2(arr.length - 1, arr, wt, w, dp));
        System.out.println(funcBU(arr, wt, w));
    }

    public static int func(int idx, int[] arr, int[] wt, int w) {
        if (idx == 0) {
            if (wt[0] <= w)
                return arr[0];
            else return 0;
        }
        int notTake = func(idx - 1, arr, wt, w);
        int take = Integer.MIN_VALUE;
        if (w >= wt[idx]) {
            take = arr[idx] + func(idx - 1, arr, wt, w - wt[idx]);
        }
        return Math.max(take, notTake);
    }

    public static int func2(int idx, int[] arr, int[] wt, int w, int[][] dp) {
        if (idx == 0) {
            if (wt[0] <= w)
                return arr[0];
            else return 0;
        }
        if (dp[idx][w] != -1) return dp[idx][w];
        int notTake = func2(idx - 1, arr, wt, w, dp);
        int take = Integer.MIN_VALUE;
        if (w >= wt[idx]) {
            take = arr[idx] + func2(idx - 1, arr, wt, w - wt[idx], dp);
        }
        return dp[idx][w] = Math.max(take, notTake);
    }

    public static int funcBU(int[] arr, int[] wt, int w) {
        int[][] dp = new int[arr.length][w + 1];
        for (int i = wt[0]; i <= w; i++)
            dp[0][i] = arr[0];

        for (int idx = 1; idx < arr.length; idx++) {
            for (int i = 0; i <= w; i++) {

                int notTaken = 0 + dp[idx - 1][i];
                int taken = Integer.MIN_VALUE;
                if (wt[idx] <= i)
                    taken = arr[idx] + dp[idx - 1][i - wt[idx]];

                dp[idx][i] = Math.max(taken, notTaken);

            }
        }
        return dp[arr.length - 1][w];
    }
}
