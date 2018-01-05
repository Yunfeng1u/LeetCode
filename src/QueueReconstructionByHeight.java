import java.util.*;

/**
 * TODO 406. Queue Reconstruction by Height
 * <p>
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 * <p>
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in
 * front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] result = reconstructQueue(new int[][]{
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        });
    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);

    }
}
