// Time Complexity : for minCost2 O(m*n)
// Space Complexity : minCost2 O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class PaintHouse {
    public int minCost(int[][] costs){
        int colorR = helper(costs,0,0,0);
        int colorB = helper(costs,0,1,0);
        int colorG = helper(costs,0,2,0);

        return Math.min(colorB,Math.min(colorG,colorR));
    }

    private int helper( int[][] costs, int row, int color, int totalAmt) {
        //base

        if (row == costs.length) return totalAmt;

        //logic
        if (color == 0) {
            Math.min(helper(costs, row + 1, 1, totalAmt + costs[row][0]),
                    helper(costs, row + 1, 2, totalAmt + costs[row][0]));
        }
        if (color == 1) {
            Math.min(helper(costs, row + 1, 0, totalAmt + costs[row][1]),
                    helper(costs, row + 1, 2, totalAmt + costs[row][1]));

        }
        if (color == 1) {
            Math.min(helper(costs, row + 1, 0, totalAmt + costs[row][2]),
                    helper(costs, row + 1, 2, totalAmt + costs[row][2]));
        }
        return totalAmt;

    }
    public int minCost1(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int m = costs.length;

        int[][] dp = new int[m][3];

        dp[m - 1][0] = costs[m - 1][0];
        dp[m - 1][1] = costs[m - 1][1];
        dp[m - 1][2] = costs[m - 1][2];
//        dp[m-1][0] = costs[m-1][0];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
//        int m = costs.length;
        public int minCost2(int[][] costs){
            if(costs==null || costs.length==0) return 0;
            int m = costs.length;

//        int[]dp1 = new int[3];

        int colorR = costs[m-1][0];  //dp[0]
        int colorB = costs[m-1][0];  //dp[1]
        int colorG = costs[m-1][0];  //dp[2]
//        dp[m-1][0] = costs[m-1][0];
        for (int i = m-2; i>=0; i--) {
//            int tempR = dp[0]; int tempB= dp[1];
            int tempR = colorR; int tempB= colorB;
            colorR= costs[i][0]+Math.min(tempB,colorG);
            colorB= costs[i][1]+Math.min(tempR,colorG);
            colorG= costs[i][2]+Math.min(tempR,tempB);
        }

        return Math.min(colorR, Math.min(colorB,colorG));

    }
}
