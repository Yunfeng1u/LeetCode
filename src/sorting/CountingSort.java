package sorting;

import utils.Log;

import java.util.Arrays;

/**
 * Created by luyunfeng on 2019/4/9.
 * 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] sorted = sort(new int[]{10, 18, 22, 29, 31, 14, 22, 21, 18, 16});
        Log.d(sorted);
    }

    public static int[] sort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] map = new int[max - min + 1];

        for (int num : nums) {
            map[num - min]++;
        }

        int j = 0;
        for (int i = 0; i < map.length;) {
            if (map[i] > 0) {
                nums[j] = i + min;
                map[i]--;
                j++;
            }else{
                i++;
            }
        }
        return nums;
    }
}
