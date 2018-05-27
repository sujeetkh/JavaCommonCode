package in.iisc.csa.sujeet.algorithms.dprogramming;

public class SubsetSum {
	public static boolean isSumRecursive(int[] arr, int i, int sum) {
		if (sum == 0)
			return true;

		if (sum < 0 || i >= arr.length)
			return false;
		boolean result = isSumRecursive(arr, i + 1, sum - arr[i]) || isSumRecursive(arr, i + 1, sum);
		return result;
	}

	public static boolean isSumDP(int[] arr) {
		int sum = arraySum(arr);
		if (sum % 2 == 1)
			return false;
		sum = sum / 2;
		boolean[][] aux = new boolean[sum + 1][arr.length + 1];
		for (int j = 0; j <= arr.length; j++)
			aux[0][j] = true;

		for (int i = 1; i <= sum; i++)
			aux[i][0] = false;

		for (int i = 1; i <= sum; i++)
			for (int j = 1; j <= arr.length; j++) {
				aux[i][j] = aux[i][j - 1];
				if (i >= arr[j - 1])
					aux[i][j] = aux[i][j] || aux[i - arr[j - 1]][j - 1];
			}

		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= arr.length; j++)
				System.out.print(aux[i][j] + ",");
			System.out.println(" ");
		}
		return aux[sum][arr.length];
	}

	public static int arraySum(int[] arr) {
		int sum = 0;
		for (int value : arr)
			sum += value;
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		int sum = arraySum(arr);
		if (sum % 2 == 0 && isSumDP(arr))
			System.out.println("Subset present for :" + sum / 2);
		else
			System.out.println("Subset not present for :" + sum / 2);
	}
}
