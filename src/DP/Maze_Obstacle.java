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
}
