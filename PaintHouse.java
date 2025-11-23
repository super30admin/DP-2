// Approach: Initialze costs of each color to paint the first house.
// Iterate through the next rows/houses and consider each color + min(previous house colors)
// Time complexity: O(N); N = costs.length
// Space complexity: O(1)
public class PaintHouse {
    public int minCost(int[][] costs) {
        int costRed = costs[0][0]; // 17 // 18 // 21
        int costBlue = costs[0][1]; // 2 // 33 // 10
        int costGreen = costs[0][2]; // 17 // 7 // 37
        for (int i = 1; i < costs.length; i ++) {
            int prevCostRed = costRed;
            int prevCostBlue = costBlue;
            int prevCostGreen = costGreen;
            costRed = costs[i][0] + Math.min(prevCostBlue, prevCostGreen); // 16 + 2 // 14 + 7
            costBlue = costs[i][1] + Math.min(prevCostRed, prevCostGreen); // 16 + 17 // 3 + 7
            costGreen = costs[i][2] + Math.min(prevCostRed, prevCostBlue); // 5 + 2 // 19 + 18
        }
        return Math.min(costRed, Math.min(costBlue, costGreen)); // min of 21, 10, 7 = 7
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        int[][] costs1 = new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(paintHouse.minCost(costs1));
        int[][] costs2 = new int[][] {{7,6,2}};
        System.out.println(paintHouse.minCost(costs2));
        int[][] costs3 = new int[][] {{17, 10, 18}, {16, 14, 15}, {11, 10, 19}, {20, 5, 7}};
        System.out.println(paintHouse.minCost(costs3));
    }
}
