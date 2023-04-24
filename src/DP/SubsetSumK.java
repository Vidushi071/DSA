package DP;

import java.util.*;

public class SubsetSumK {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4};
        int k = 4;
        int[][] dp = new int[arr.length][k + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        System.out.print(func(arr, k, arr.length - 1));


    }

    public static boolean func(int[] arr, int target, int idx) {
        if (target == 0)
            return true;
        if (idx == 0) return arr[0] == target;
        boolean take = false;
        boolean nTake = func(arr, target, idx - 1);
        if (target >= arr[idx])
            take = func(arr, target - arr[idx], idx - 1);
        return take || nTake;
    }

}
