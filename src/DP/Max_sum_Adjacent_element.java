package DP;

import java.util.Arrays;

public class Max_sum_Adjacent_element {
    public static void main(String args[]) {
        int arr[] = {2, 7, 9, 3, 1};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        System.out.print(maxSum(arr.length - 1, arr, dp));
    }

    public static int maxSum(int idx, int[] arr, int[] dp) {
        if (idx == 0)
            return arr[idx];
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int pick = arr[idx] + maxSum(idx - 2, arr, dp);
        int notPick = 0 + maxSum(idx - 1, arr, dp);
        return dp[idx] = Math.max(pick, notPick);
    }
}
//House Robber problem same