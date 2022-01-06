/**
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] res = new int[2];
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else if (numbers[index1] + numbers[index2] > target) {
                index2--;
            } else {
                break;
            }
        }
        res[0] = index1 + 1;
        res[1] = index2 + 1;
        return res;
    }
}
