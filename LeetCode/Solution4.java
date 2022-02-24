/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {
	//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		if (nums1.length == 0)  return calMedian(nums2);
//		if (nums2.length == 0)  return calMedian(nums1);
//		int low1 = 0, low2 = 0;
//		int high1 = nums1.length, high2 = nums2.length;
//		int mid1 = (low1 + high1) / 2, mid2 = (low2 + high2) / 2;
//		while (true) {
//
//		}
//	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0) return calMedian(nums2);
		if (nums2.length == 0) return calMedian(nums1);

		return calMedian(merge(nums1, nums2));
	}


	public int[] merge(int[] nums1, int[] nums2) {
		int idx = 0, idx1 = 0, idx2 = 0;
		int[] res = new int[nums1.length + nums2.length];

		while (idx1 < nums1.length && idx2 < nums2.length)
			res[idx++] = (nums1[idx1] < nums2[idx2]) ? nums1[idx1++] : nums2[idx2++];

		if (idx1 == nums1.length)
			while (idx2 < nums2.length)
				res[idx++] = nums2[idx2++];
		else
			while (idx1 < nums1.length)
				res[idx++] = nums1[idx1++];

		return res;
	}

	public double calMedian(int[] arr) {
		int mid = arr.length / 2;
		return (arr.length % 2 == 0) ? (arr[mid - 1] + arr[mid]) / 2.0 : arr[mid];
	}
}
