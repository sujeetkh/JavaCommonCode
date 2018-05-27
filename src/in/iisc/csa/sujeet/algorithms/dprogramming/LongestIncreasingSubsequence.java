package in.iisc.csa.sujeet.algorithms.dprogramming;

import java.lang.Math;

public class LongestIncreasingSubsequence {

	public static int lis(int[] arr) {
		int[] lis = new int[arr.length];
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < arr.length; i++)
			for (int j = 0; j < i; j++)
				if (i > j && arr[i] > arr[j])
					lis[i] = Math.max(lis[i], lis[j] + 1);
		int max = 0;
		for (int i = 0; i < lis.length; i++) {
			max = Math.max(lis[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 50, 90 };
		System.out.println(lis(arr));
	}

}
