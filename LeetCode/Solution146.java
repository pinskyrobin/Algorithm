import java.util.HashMap;
import java.util.List;

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LRUCache {
	HashMap<Integer, Integer> LRU;
	int[] freqs;

	public LRUCache(int capacity) {
		LRU = new HashMap<>(capacity);
		freqs = new int[capacity];

		for (int i = 0; i < capacity; i++) {
			freqs[i] = -1;
		}
	}

	public int get(int key) {
		// 确实有这个元素
		if (LRU.containsKey(key)) {
			// 找到它的位置
			int index = 0;
			for (int i = 0; i < freqs.length; i++) {
				if (freqs[i] == key) {
					index = i;
					break;
				}
			}
			// 更新（将它移至队列首位）
			int temp = freqs[index];
			System.arraycopy(freqs, 0, freqs, 1, index);
			freqs[0] = temp;
			return LRU.get(key);
		}
		return -1;
	}

	/**
	 * 情况一：更新键值对
	 * 情况二：缓存满，寻找最近最少使用
	 * 情况三：缓存未满，直接添加
	 */
	public void put(int key, int value) {
		// 缓存满，且不更新
		if (!LRU.containsKey(key) && LRU.size() == freqs.length) {
			LRU.remove(freqs[freqs.length - 1]);
			LRU.put(key, value);
			System.arraycopy(freqs, 0, freqs, 1, LRU.size() - 1);
			freqs[0] = key;
			return;
		}

		// 更新
		if (LRU.containsKey(key)) {
			int index = 0;
			for (int i = 0; i < LRU.size(); i++) {
				if (freqs[i] == key) {
					index = i;
					break;
				}
			}

			if (freqs[0] != key) {
				System.arraycopy(freqs, 0, freqs, 1, index);
				freqs[0] = key;
			}
			LRU.put(key, value);
			return;
		}

		// 直接添加
		System.arraycopy(freqs, 0, freqs, 1, LRU.size());
		freqs[0] = key;
		LRU.put(key, value);
	}
}
