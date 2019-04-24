package sorting;

import utils.Log;

import java.util.*;

/**
 * Created by luyunfeng on 2019/4/9.
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] sorted = sort(new double[]{ 12.5, 10.1, 11.8, 18.31, 14.29});
        Log.d(sorted);
    }

    public static double[] sort(double[] nums) {

        List<Queue<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            Queue<Double> queue = new PriorityQueue<>();
            buckets.add(queue);
        }

        double min = nums[0];
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        double capacity = (max - min) / (nums.length - 1);

        for (int i = 0; i < nums.length; i++) {

            System.out.println(nums[i]);

            int index = (int) ((nums[i] - min) / capacity);

            System.out.println(index);
            System.out.println();

            buckets.get(index).add(nums[i]);
        }

        int i = 0;
        for (Queue<Double> bucket : buckets) {
            while (!bucket.isEmpty()){
                nums[i] = bucket.poll();
                i++;
            }
        }

        return nums;
    }
}
