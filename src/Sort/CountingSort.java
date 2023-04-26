package Sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String args[]) {
        int arr[] = {0, 4, 2, 2, 7, 6, 9, 0, 1, 5, 8, 1, 9};
        arr = Sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

    public static int[] Sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] frq = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            frq[arr[i]]++;

        }
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i - 1] + frq[i];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = frq[arr[i]];
            ans[pos - 1] = arr[i];
            frq[arr[i]]--;

        }
        return ans;
    }
}
