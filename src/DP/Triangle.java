package DP;

import java.util.Arrays;

public class Triangle {
    public static void main(String args[]) {
        int arr[][] = {{1, 0, 0, 0}, {2, 3, 0, 0}, {4, 5, 6, 0}, {7, 8, 9, 10}};
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(path(arr, 0, 0, n));
        System.out.println(pathTD(arr, 0, 0, n, dp));
        System.out.println(pathBu(arr, dp, n));
    }

    public static int path(int[][] arr, int i, int j, int n) {
        if (i == n - 1) return arr[n - 1][j];
        int down = arr[i][j] + path(arr, i + 1, j, n);
        int dia = arr[i][j] + path(arr, i + 1, j + 1, n);
        return Math.min(down, dia);
    }

    public static int pathTD(int[][] arr, int i, int j, int n, int[][] dp) {
        if (i == n - 1) return arr[n - 1][j];
        if (dp[i][j] != -1) return dp[i][j];
        int down = arr[i][j] + pathTD(arr, i + 1, j, n, dp);
        int dia = arr[i][j] + pathTD(arr, i + 1, j + 1, n, dp);
        return dp[i][j] = Math.min(down, dia);
    }

    public static int pathBu(int[][] arr, int[][] dp, int n) {
        for (int j = 0; j < n; j++)
            dp[n - 1][j] = arr[n - 1][j];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = arr[i][j] + dp[i + 1][j];
                int dia = arr[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, dia);
            }
        }
        return dp[0][0];
    }
}
