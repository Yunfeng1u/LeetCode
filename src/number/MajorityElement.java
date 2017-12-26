package number;

import utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * <p>
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int result = majorityElement(new int[]{2,2,1,1,1,2,2});
        Log.d(result);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int majorityLimit = nums.length / 2;
        Log.d(majorityLimit);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value != null) {
                value++;
                if (value > majorityLimit) {
                    return num;
                }
                map.put(num, value);
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }

    public static int majorityElementS(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
