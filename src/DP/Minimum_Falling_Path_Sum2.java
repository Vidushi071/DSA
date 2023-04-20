package DP;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum2 {
    public static void main(String args[]) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.min(ans, Falling_Path_Sum(arr, 0, i, dp));

        }
        System.out.print(ans);
    }

    public static int Falling_Path_Sum(int[][] arr, int i, int j, int[][] dp) {
        if (i == arr.length - 1)
            return arr[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < arr[0].length; col++) {

            if (col != j) {
                ans = Math.min(ans, Falling_Path_Sum(arr, i + 1, col, dp));
            }
        }
        return dp[i][j] = ans + arr[i][j];

    }
}
