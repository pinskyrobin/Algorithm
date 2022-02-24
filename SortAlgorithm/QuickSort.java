import java.util.Random;

public class QuickSort {
	static Random rand = new Random();

	public static void quickSort(int[] nums, int start, int end) {
		if (start < end) {
			int p = partition(nums, start, end);
			quicksort(nums, start, p - 1);
			quicksort(nums, p + 1, end);
		}
	}

	public static int partition(int[] nums, int start, int end) {
		// point：随机生成pivot
		int pivot = rand.nextInt(end - start + 1) + start;
		int i = start, j = end;
		int base = nums[pivot];
		// point：将pivot位与起始位交换
		swap(nums, start, pivot);
		while (i < j) {
			while (i < j && nums[j] >= base)    j--;
			while (i < j && nums[i] <= base)    i++;
			if (i < j)  swap(nums, i, j);
		}
		// point：最后将分割点位与起始位交换
		swap(nums, start, i);
		return i;
	}

	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
