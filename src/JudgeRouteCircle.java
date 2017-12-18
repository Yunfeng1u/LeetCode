/**
 * 657. Judge Route Circle
 * https://leetcode.com/problems/judge-route-circle/description/
 * <p>
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeRouteCircle {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }

    /**
     * O(N), O(N)
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {

        char[] chars = moves.toCharArray();

        int countV = 0;
        int countH = 0;
        for (char aChar : chars) {
            switch (aChar){
                case 'R':
                    countH--;
                    break;
                case 'L':
                    countH++;
                    break;
                case 'U':
                    countV--;
                    break;
                case 'D':
                    countV++;
                    break;
            }
        }
        return countV == 0 && countH == 0;
    }

}
