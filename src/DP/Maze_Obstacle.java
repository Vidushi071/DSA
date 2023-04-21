package DP;

import java.util.Arrays;

public class Maze_Obstacle {
    public static void main(String args[]) {
        int[][] arr = {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}};
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.print(path(arr, dp, arr.length - 1, arr[0].length - 1));
    }

    public static int path(int[][] grid, int[][] dp, int i, int j) {
        if (i >= 0 && j >= 0 && grid[i][j] == -1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        int up = path(grid, dp, i - 1, j);
        int left = path(grid, dp, i, j - 1);
        return dp[i][j] = up + left;
    }

    public static int pathsBU(int arr[][], int[][] dp) {
        dp[0][0] = 1;
        int up = 0, left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (i >= 0 && j >= 0 && arr[i][j] == -1)
                    dp[i][j] = 0;
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
//Unique Paths 2