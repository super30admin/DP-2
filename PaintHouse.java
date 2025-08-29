//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
public class PaintHouse {

    /**
     *
     * @param costs the 2D array where each row represents the cost of painting that house with red/blue/green color
     * @return      the minimum cost to paint all the houses without adjacent houses having the same color
     */
    public int minCost(int[][] costs) {
        int n = costs.length;

        int red = costs[n - 1][0];
        int blue = costs[n - 1][1];
        int green = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            int tempR = red;
            red = costs[i][0] + Math.min(blue, green);
            int tempB = blue;
            blue = costs[i][1] + Math.min(tempR, green);
            green = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(red, Math.min(blue, green));
    }

    public static void main(String[] args) {
        final PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(new int[][] {
                {17, 2, 16}, //17 + 24, 2 + 24, 16 + 25
                {18, 5, 14}, //18 + 10, 5 + 20, 14 + 10
                {13, 3, 19}, //13 + 7, 3 + 7, 19 + 8
                {12, 8, 7}
        })); //return 26

        System.out.println(paintHouse.minCost(new int[][] {
                {7, 6, 2} //2
        })); //return 2
    }
}
