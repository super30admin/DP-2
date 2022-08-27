// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;

        int n = costs.length;
        int[][] dp = new int[n][3]; //[houses][colors]

        for(int j=0;j<3;j++){
            dp[n-1][j] = costs[n-1][j];
        }

        for(int i=n-2;i>=0;i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}



 /*brute-force
        //case1
        int caseR = helper(costs, 0, 0 ,0);

        //case2
        int caseB = helper(costs, 0, 1, 0);

        //case3
        int caseG = helper(costs, 0, 2, 0);

        return Math.min(caseR, Math.min(caseB, caseG));
    }

    private int helper(int[][] costs, int idx, int color, int amount){
        //base
        if(idx == costs.length)
            return amount;

        //logic
        if(color==0){ //red
            //blue or green
            return Math.min(helper(costs, idx+1, 1, amount+costs[idx][0]), helper(costs, idx+1, 2, amount+costs[idx][0]));
        }
        if(color==1){ //blue
            //red or green
            return Math.min(helper(costs, idx+1, 0, amount+costs[idx][1]), helper(costs, idx+1, 2, amount+costs[idx][1]));
        }
        if(color==2){ //green
            //red or blue
            return Math.min(helper(costs, idx+1, 0, amount+costs[idx][2]), helper(costs, idx+1, 1, amount+costs[idx][2]));
        }
        return 790894;*/