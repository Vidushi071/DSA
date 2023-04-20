package DP;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {
    public static void main(String args[]) {
        int[][] arr = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
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
        if (j < 0 || j >= arr[0].length)
            return Integer.MAX_VALUE;

        if (i == arr.length - 1)
            return arr[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];
        int a = Falling_Path_Sum(arr, i + 1, j - 1, dp);
        int b = Falling_Path_Sum(arr, i + 1, j, dp);
        int c = Falling_Path_Sum(arr, i + 1, j + 1, dp);
        return dp[i][j] = arr[i][j] + Math.min(a, Math.min(b, c));

    }
}
