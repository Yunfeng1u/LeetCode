package number;

import utils.Log;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Log.d(topKFrequent(new int[]{-1,-1}, 1));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>(k);

        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 0;
            }
            map.put(num, ++count);
        }

        List<Integer>[] bucketArray = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            List<Integer> list = bucketArray[count];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            bucketArray[count] = list;
        }

        for (int i = bucketArray.length - 1; i >= 0; i--) {
            List<Integer> numbers = bucketArray[i];
            if (numbers != null && res.size() < k) {
                res.addAll(numbers);
            }
        }

        if (res.size() > k){
            res = res.subList(0, k);
        }

        return res;
    }
}
