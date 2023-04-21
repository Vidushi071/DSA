package DP;

import java.util.Arrays;

public class Total_UniquePaths {
    public static void main(String args[]) {
        int arr[][] = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.println(paths(arr, arr.length - 1, arr[0].length - 1, dp));
        System.out.print(pathsBU(arr, dp));
    }

    public static int paths(int[][] arr, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = paths(arr, i - 1, j, dp);
        int left = paths(arr, i, j - 1, dp);
        return dp[i][j] = up + left;
    }

    public static int pathsBU(int arr[][], int[][] dp) {
        dp[0][0] = 1;
        int up = 0, left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
