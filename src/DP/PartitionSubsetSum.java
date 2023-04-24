package DP;

import java.util.Arrays;

public class PartitionSubsetSum {
    public static void main(String args[]) {
        int arr[] = {2, 3, 3, 3, 4, 5};
        System.out.println(func(arr));

    }

    public static boolean func(int[] arr) {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++)
            totSum += arr[i];
        if (totSum % 2 == 1) {
            return false;
        }
        int k = totSum / 2;

        int[][] dp = new int[arr.length][k + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return funcTD(arr, k, arr.length - 1, dp);

    }

    public static boolean funcTD(int[] arr, int target, int idx, int[][] dp) {
        if (target == 0)
            return true;
        if (idx == 0) return arr[0] == target;
        if (dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;
        boolean take = false;
        boolean nTake = funcTD(arr, target, idx - 1, dp);
        if (target >= arr[idx])
            take = funcTD(arr, target - arr[idx], idx - 1, dp);
        dp[idx][target] = take || nTake ? 1 : 0;
        return take || nTake;
    }

}
