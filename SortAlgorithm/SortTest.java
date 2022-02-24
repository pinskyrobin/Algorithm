import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		// [1, 2, 2, 3, 3, 4, 5, 5, 6]
		int[] arr = new int[] {3,2,1,5,6,4};
		QuickSort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
