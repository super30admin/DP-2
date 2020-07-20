// Time Complexity : O(A.N) => O(3N) =>O(N) where A is number of colors and N is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Since 2 adjacent houses cannot be painted by same color, I have to make sure while coloring house red,
// the adjacent needs to be blue of green. So using dp approach, while coloring a house X with color red, I need to
// consider the cost of painting current house red and the minimum of coloring the previous house either blue or green
// We make similar decision for each house while coloring in other colors. At the end, we get the cost of coloring blue,
// green and red and minimum out of those values is the min cost to paint the houses.

public class HousePaint {
    public static void main(String[] args) {
        int[][] houses = {{7, 4, 5}, {6, 2, 1}, {4, 3, 7}};
        System.out.println("Minimum cost of painting(Recursion):");
        getPaintCostRecursive(houses);
        System.out.println("Minimum cost of painting(DP):");
        getPaintCostDP(houses);
    }

    private static void getPaintCostDP(int[][] houses) {
        int row = houses.length;
        for (int i = 1; i < row; i++) {
            houses[i][0] += Math.min(houses[i - 1][1], houses[i - 1][2]);
            houses[i][1] += Math.min(houses[i - 1][0], houses[i - 1][2]);
            houses[i][2] += Math.min(houses[i - 1][1], houses[i - 1][0]);
        }

        int minCost = Math.min(houses[row - 1][0], Math.min(houses[row - 1][1], houses[row - 1][2]));
        System.out.println(minCost);
    }

    private static void getPaintCostRecursive(int[][] houses) {
        int paintMinCostRed = getMinPaintCost(houses, 0, 0, 0);
        int paintMinCostGreen = getMinPaintCost(houses, 0, 1, 0);
        int paintMinCostBlue = getMinPaintCost(houses, 0, 2, 0);
        System.out.println(Math.min(paintMinCostBlue, Math.min(paintMinCostGreen, paintMinCostRed)));
    }

    private static int getMinPaintCost(int[][] houses, int minCost, int prevColor, int row) {
        if (houses.length == row) {
            return minCost;
        }

        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;

        if (prevColor == 0) {
            case1 = Math.min(getMinPaintCost(houses, minCost + houses[row][1], 1, row + 1),
                    getMinPaintCost(houses, minCost + houses[row][2], 2, row + 1));
        }

        if (prevColor == 1) {
            case2 = Math.min(getMinPaintCost(houses, minCost + houses[row][0], 0, row + 1),
                    getMinPaintCost(houses, minCost + houses[row][2], 2, row + 1));
        }

        if (prevColor == 2) {
            case3 = Math.min(getMinPaintCost(houses, minCost + houses[row][1], 1, row + 1)
                    , getMinPaintCost(houses, minCost + houses[row][0], 0, row + 1));

        }

        return Math.min(case3, Math.min(case1, case2));
    }
}
