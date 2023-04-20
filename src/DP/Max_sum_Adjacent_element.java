package DP;

import java.util.Arrays;

public class Max_sum_Adjacent_element {
    public static void main(String args[]) {
        int arr[] = {2, 7, 9, 3, 1};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSum(arr.length - 1, arr, dp));
        System.out.println(maxSumBU(arr, dp));
        System.out.print(maxSumSpace(arr));
    }

    // TC all : O(N)
    public static int maxSum(int idx, int[] arr, int[] dp) {
//        SC: O(N) +O(N)
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

    public static int maxSumBU(int[] arr, int[] dp) {
//        SC: O(N)
        dp[0] = arr[0];
        for (int idx = 1; idx < arr.length; idx++) {
            int take = arr[idx];
            if (idx > 1)
                take += dp[idx - 2];
            int notTake = 0 + dp[idx - 1];
            dp[idx] = Math.max(take, notTake);
        }
        return dp[dp.length - 1];
    }

    public static int maxSumSpace(int[] arr) {
//        SC: O(1)
        int prev = arr[0];
        int prev2 = 0;
        for (int idx = 1; idx < arr.length; idx++) {
            int take = arr[idx];
            if (idx > 1)
                take += prev2;
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
//House Robber problem same