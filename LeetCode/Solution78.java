import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
class Solution78 {

    public static List<Integer> t = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(subsets_bfs(nums));
        System.out.println(subsets_dfs(nums));
    }

    public static List<List<Integer>> subsets_bfs(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l;
        int len;
        for (int num : nums) {
            len = list.size();
            list.addAll(list);
            for (int i = 0; i < list.size() / 2; i++) {
                l = new ArrayList<>(list.get(i));
                l.add(num);
                list.set(i, l);
            }
            list.add(Collections.singletonList(num));
        }
        list.add(new ArrayList<>());
        return list;
    }

    public static List<List<Integer>> subsets_dfs(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[index]);
        dfs(index + 1, nums);
        t.remove(t.size() - 1);
        dfs(index + 1, nums);
    }
}
