package number;

import utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets
 * <p>
 * https://leetcode.com/problems/subsets/description/
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        Log.d(subsets(array));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(nums);
        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
