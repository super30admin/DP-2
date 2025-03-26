/**
 * Approach -1 Recursion
 * TC: O(2^n) * 3 -> n is the number of houses and 3 is the colors
 * SC: O(m+n)
 */
public class PaintHouse {
    public int minCost(int[][] costs) { // 0-R, 1 -B, 2-G
        int colorR = helper(costs, 0, 0, 0);
        int colorB = helper(costs, 0, 1, 0);
        int colorG = helper(costs, 0, 2, 0);

        return Math.min(colorR, Math.min(colorB, colorG));
    }

    private int helper(int[][] costs, int i, int color, int totalCost) {
        // base case
        if (i == costs.length) {
            return totalCost;
        }

        if (color == 0) {
            return Math.min(helper(costs, i + 1, 1, totalCost + costs[i][0]),
                    helper(costs, i + 1, 2, totalCost + costs[i][0]));
        } else if (color == 1) {
            return Math.min(helper(costs, i + 1, 0, totalCost + costs[i][1]),
                    helper(costs, i + 1, 2, totalCost + costs[i][1]));
        } else if (color == 2) {
            return Math.min(helper(costs, i + 1, 0, totalCost + costs[i][2]),
                    helper(costs, i + 1, 1, totalCost + costs[i][2]));
        }

        return -1;
    }
}

/**
 * Approach - 2
 * TC: O(m) since n is fixed at 3
 * SC: O(m) since n is fixed at 3
 */
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        dp[m - 1][0] = costs[m - 1][0];
        dp[m - 1][1] = costs[m - 1][1];
        dp[m - 1][2] = costs[m - 1][2];

        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

/**
 * Approach - 3
 * TC: O(m) since n is fixed at 3
 * SC: O(1) as we used only 3 variables instead of 2D array
 */

class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

        int colorR = costs[m - 1][0];
        int colorB = costs[m - 1][1];
        int colorG = costs[m - 1][2];

        for (int i = m - 2; i >= 0; i--) {
            int tmpR = colorR;
            int tmpB = colorB;

            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tmpR, colorG);
            colorG = costs[i][2] + Math.min(tmpR, tmpB);
        }
        return Math.min(colorR, Math.min(colorB, colorG));
    }
}