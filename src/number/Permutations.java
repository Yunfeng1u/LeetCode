package number;

import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * https://leetcode.com/problems/permutations/description/
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1, 2, 3,4});
        Log.d(result);
    }

    public static List<List<Integer>> permute(final int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }

        if (nums.length == 1) {
            res.add(new ArrayList<Integer>() {{
                add(nums[0]);
            }});
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] subPart = new int[nums.length - 1];

            System.arraycopy(nums, 0, subPart, 0, i);
            System.arraycopy(nums, i + 1, subPart, i, nums.length - 1 - i);

            List<List<Integer>> subRes = permute(subPart);

            for (List<Integer> subRe : subRes) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subRe);
                res.add(list);
            }
        }
        return res;
    }
}
