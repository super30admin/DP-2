// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Dynamic Programming approach TC: O(n) and SC: O(n) where n is the number of elements in the input
class PaintHouse{
    public int minCost(int[][] costs){

        //null check
        if(costs == null || costs.length == 0)
            return 0;

        int n= costs.length;
        //create a new matrix of same size of costs row = costs.length and columns = 3(fixed R,B,G)
        int[][] dp = new int[n][3];

        //fill the last row as it is in costs matrix
        for(int j=0 ; j<3 ; j++){
            dp[n-1][j] = costs[n-1][j];
        }

        for(int i=n-2 ; i >= 0 ; i-- ){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1] , dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0] , dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0] , dp[i+1][1]);
        }
        return Math.min(dp[0][0] , Math.min(dp[0][1] , dp[0][2] ));
    }
}


/* This is recursive method TC: 2^n where n is number of possibilities in the diagram. This gives Time Limit Exceeded in LC, so we go with DP approach.

class Solution {
    public int minCost(int[][] costs) {

        //null check
        if(costs == null || costs.length == 0){
            return 0;
        }


        int caseR = helper(costs,0,0,0);
        int caseB = helper(costs,0,1,0);
        int caseG = helper(costs,0,2,0);

        return Math.min(caseR, Math.min(caseB,caseG));
    }

    //color = 0 red , 1 blue, 2 green
    private int helper(int[][] costs, int idx, int color, int amount){


        //base case
        if(idx == costs.length)
            return amount;


        //logic
        if(color == 0){
            //red is chosen
            return Math.min((helper(costs,idx+1,1,amount + costs[idx][0])),(helper(costs,idx+1,2, amount + costs[idx][0])));
        }

        if(color == 1){
            //blue is chosen
            return Math.min((helper(costs,idx+1,0,amount + costs[idx][1])), (helper(costs,idx+1,2,amount + costs[idx][1])));
        }

        if(color == 2){
            //green is chosen
            return Math.min((helper(costs,idx+1,0,amount + costs[idx][2])), (helper(costs,idx+1,1,amount + costs[idx][2])));
        }
        return 99999;
    }
}

*/
