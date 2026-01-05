import java.util.Arrays;

/*
PAINT HOUSE (LeetCode 256)

Goal: Min cost to paint all houses such that no two adjacent houses have the same color.
costs[i][c] = cost to paint house i with color c (c in {0,1,2}).

Approaches:
1) Pure Recursion (exponential)
2) Top-Down DP (Memoization)
3) Bottom-Up DP (2D)
4) Bottom-Up DP (O(1) space)

Time:
- Recursion: exponential
- DP: O(n)
Space:
- Memo/2D: O(n)
- O(1) space: constant
*/

public class PaintHouse {

    /* 1) PURE RECURSION*/
    public int minCostRecursive(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        return Math.min(
                helperRec(costs, 0, 0),
                Math.min(helperRec(costs, 0, 1), helperRec(costs, 0, 2))
        );
    }

    private int helperRec(int[][] costs, int i, int color) {
        int n = costs.length;
        if (i == n) return 0;

        int costHere = costs[i][color];
        if (i == n - 1) return costHere;

        int nextMin;
        if (color == 0) nextMin = Math.min(helperRec(costs, i + 1, 1), helperRec(costs, i + 1, 2));
        else if (color == 1) nextMin = Math.min(helperRec(costs, i + 1, 0), helperRec(costs, i + 1, 2));
        else nextMin = Math.min(helperRec(costs, i + 1, 0), helperRec(costs, i + 1, 1));

        return costHere + nextMin;
    }

    /* 2) TOP-DOWN DP (MEMO) */
    private int[][] memo;

    public int minCostTopDown(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        memo = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        return Math.min(
                helperMemo(costs, 0, 0),
                Math.min(helperMemo(costs, 0, 1), helperMemo(costs, 0, 2))
        );
    }

    private int helperMemo(int[][] costs, int i, int color) {
        int n = costs.length;
        if (i == n) return 0;
        if (memo[i][color] != -1) return memo[i][color];

        int costHere = costs[i][color];
        int bestNext;

        if (i == n - 1) {
            memo[i][color] = costHere;
            return memo[i][color];
        }

        if (color == 0) bestNext = Math.min(helperMemo(costs, i + 1, 1), helperMemo(costs, i + 1, 2));
        else if (color == 1) bestNext = Math.min(helperMemo(costs, i + 1, 0), helperMemo(costs, i + 1, 2));
        else bestNext = Math.min(helperMemo(costs, i + 1, 0), helperMemo(costs, i + 1, 1));

        memo[i][color] = costHere + bestNext;
        return memo[i][color];
    }

    /* 3) BOTTOM-UP DP (2D) */
    public int minCost2D(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;

        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    /* 4) BOTTOM-UP DP (O(1)) */
    public int minCostOptimized(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;

        int r = costs[0][0];
        int g = costs[0][1];
        int b = costs[0][2];

        for (int i = 1; i < n; i++) {
            int newR = costs[i][0] + Math.min(g, b);
            int newG = costs[i][1] + Math.min(r, b);
            int newB = costs[i][2] + Math.min(r, g);
            r = newR;
            g = newG;
            b = newB;
        }

        return Math.min(r, Math.min(g, b));
    }
}
