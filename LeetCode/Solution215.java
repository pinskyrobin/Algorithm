import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Solution215 {
	// 优先队列（最小堆）版本
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int num : nums) {
			heap.add(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}

	// 递归版本
//	public int findKthLargest(int[] nums, int k) {
//		return quickSort(nums, k, 0, nums.length - 1);
//	}
//
//	// 降序快排的实现
//	private int quickSort(int[] nums, int target, int left, int right) {
//
//		int i = left, j = right;
//		int pivot = nums[left];
//		int temp = 0;
//
//		// 左右两边分别走
//		while (i < j) {
//
//			// 先遍历右边，遇到大于pivot的停止
//			while (nums[j] <= pivot && i < j) {
//				j--;
//			}
//
//			// 再遍历左边，遇到小于pivot的停止
//			while (nums[i] >= pivot && i < j) {
//				i++;
//			}
//
//			// 交换
//			temp = nums[i];
//			nums[i] = nums[j];
//			nums[j] = temp;
//		}
//
//		// 停止时指向的值与pivot交换
//		nums[left] = nums[i];
//		nums[i] = pivot;
//
//		// 符合条件则退出递归
//		if (i == target - 1) return nums[i];
//
//		// 根据停止的位置选择一边递归
//		return (i < target - 1) ? quickSort(nums, target, i + 1, right) :
//				quickSort(nums, target, left, i - 1);
//
//	}

	// 非递归版本
//	public int findKthLargest(int[] nums, int k) {
//		int left = 0;
//		int right = nums.length - 1;
//
//		int i, j, temp, pivot;
//
//		while(true) {
//			i = left;
//			j = right;
//			pivot = nums[i];
//
//			while (i < j) {
//
//				while (nums[j] <= pivot && i < j) {
//					j--;
//				}
//
//				while (nums[i] >= pivot && i < j) {
//					i++;
//				}
//
//				temp = nums[i];
//				nums[i] = nums[j];
//				nums[j] = temp;
//			}
//
//			nums[left] = nums[i];
//			nums[i] = pivot;
//
//			if (i == k - 1)         return nums[i];
//			else if (i < k - 1)     left = i;
//			else                    right = i - 1;
//		}
//	}
}
