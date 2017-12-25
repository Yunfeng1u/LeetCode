import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        List<Integer> list = findDisappearedNumbers3(new int[]{4, 3, 2, 7, 8, 2, 3, 3});
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        boolean[] map = new boolean[nums.length];

        int min = 1;

        for (int num : nums) {

            if (min > num) {
                min = num;
            }
            map[num - 1] = true;
        }

        for (int i = min; i <= nums.length; i++) {
            if (!map[i - 1]) {
                list.add(i);
            }
        }

        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % n;
            System.out.println(nums[i] + " -> " + index);
            nums[index] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
