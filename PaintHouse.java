import java.util.Arrays;

public class PaintHouse {
    // ------------------------ Solution 1 ---------------------
    /**
     * 2D Tabulation DP solution
     * Time O(m*n) Space O(m*n)
     */
    public int minCost1(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1] = costs[m - 1];

        for (int i = m - 2; i >= 0; i--) {
            for (int color = 0; color < n; color++) {
                if (color == 0) {
                    dp[i][color] = costs[i][color] + Math.min(dp[i + 1][1], dp[i + 1][2]);
                } else if (color == 1) {
                    dp[i][color] = costs[i][color] + Math.min(dp[i + 1][0], dp[i + 1][2]);
                } else if (color == 2) {
                    dp[i][color] = costs[i][color] + Math.min(dp[i + 1][0], dp[i + 1][1]);
                }
            }
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    // ------------------ Solution 2 -----------------------------
    /**
     * Same as above solution 2D Tabulation DP solution, but with
     * simplified version supporting many colors not just 3
     * Time O(m*n) Space O(m*n)
     */
    public int minCost2(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1] = costs[m - 1];

        for (int i = m - 2; i >= 0; i--) {
            for (int color = 0; color < n; color++) {
                dp[i][color] = costs[i][color] + getMinFromPrevious(dp, i + 1, color);
            }
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    private int getMinFromPrevious(int[][] dp, int row, int column) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < dp[row].length; j++) {
            if(j == column) {
                continue;
            }
            min = Math.min(min, dp[row][j]);
        }
        return min;
    }

    // --------------------- Solution 3 --------------------------------
    /**
     * Improving space for tabulation DP solution to 1D array, here colors are fixed
     * so used variables instead of 1D array
     * Time O(m*n) Space O(n) where n is no of colors could treat it constant in this particular problem
     */
    public int minCost3(int[][] costs) {
        int m = costs.length;
        int red = costs[m - 1][0];
        int blue = costs[m - 1][1];
        int green = costs[m - 1][2];

        for (int i = m - 2; i >= 0; i--) {
            int oldred = red;
            red = costs[i][0] + Math.min(blue, green);
            int oldblue = blue;
            blue = costs[i][1] + Math.min(oldred, green);
            green = costs[i][2] + Math.min(oldred, oldblue);
        }

        return Math.min(red, Math.min(blue, green));
    }

    // --------------------------- Solution 4 -------------------------------
    /**
     * Memoization DP Solution
     * Time O(n*n) Space O(n*n)
     */
    int[][] memo;
    public int minCost4(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        this.memo = new int[m][n];

        //mark memo array cells as unprocessed
        for (int[] row: memo)
            Arrays.fill(row, -1);


        int red = helper(costs, 0, 0);
        int blue = helper(costs, 0, 1);
        int green = helper(costs, 0, 2);

        return Math.min(red, Math.min(blue, green));
    }

    private int helper(int[][] costs, int idx, int color) {
        //base
        if (idx == costs.length) return 0;

        if (memo[idx][color] != -1) return memo[idx][color];

        //logic
        if (color == 0) {
            memo[idx][color] = costs[idx][color] + Math.min(helper(costs, idx + 1, 1), helper(costs, idx + 1, 2));
            return memo[idx][color];
        } else if (color == 1) {
            memo[idx][color] = costs[idx][color] + Math.min(helper(costs, idx + 1, 0), helper(costs, idx + 1, 2));
            return memo[idx][color];
        } else {
            memo[idx][color] = costs[idx][color] + Math.min(helper(costs, idx + 1, 0), helper(costs, idx + 1, 1));
            return memo[idx][color];
        }
    }
}
