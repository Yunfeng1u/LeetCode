/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{0, 5, 0, 3, 0, 1, 0, 1}));
        System.out.println(trap(new int[]{2, 5, 3, 4, 3, 4}));
    }

    public static int trap(int[] A) {
        int a = 0;
        int b = A.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, A[a]);
            rightmax = Math.max(rightmax, A[b]);
            if (leftmax < rightmax) {
                max += (leftmax - A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            } else {
                max += (rightmax - A[b]);
                b--;
            }
        }
        return max;
    }

    public static int trap2(int[] height) {
        if (height.length <= 2) return 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = height[0];
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];
            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }
        }

        return water;
    }
}
