/*
approach: dynamic programming

time: O(n)
space: O(n)
 */
public class Problem1 {
    static int minCost(int[][] costs){
        if (costs==null || costs.length==0) return 0;

        return dpHelper(costs);
    }

    static int dpHelper(int[][] costs) {
        int r = costs.length;
        int c = costs[0].length;
        int[][] dp = new int[r][c];

        for (int i=0;i<c;i++)
            dp[r-1][i] = costs[r-1][i];

        for (int i=r-2;i>=0;i--) {
            for (int j=0;j<c;j++) {
                if (j==0)
                    dp[i][j] = costs[i][j]+Math.min(dp[i+1][j+1], dp[i+1][j+2]);
                else if (j==1)
                    dp[i][j] = costs[i][j]+Math.min(dp[i+1][j-1], dp[i+1][j+1]);
                else
                    dp[i][j] = costs[i][j]+Math.min(dp[i+1][j-2], dp[i+1][j-1]);
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println("min cost for painting "+minCost(new int[][]{{17, 10, 18},{16, 14, 15},{11, 10, 14}, {20, 5, 7}}));
    }
}
