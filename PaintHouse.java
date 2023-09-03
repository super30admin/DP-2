class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int caseR = helper(costs,0,0,0);
        int caseB = helper(costs,0,1,0);
        int caseG = helper(costs,0,2,0);

        return Math.min(caseR, Math.min(caseB,caseG));

    }

    private int helper(int[][] costs, int idx, int color, int minCost){
        //base
         if(idx == costs.length) return minCost;

        //logic
        if(color == 0){
              return Math.min(
                  helper(costs, idx+1, 1, minCost + costs[idx][0]),
                  helper(costs, idx+1, 2, minCost + costs[idx][0])
            );
            
        }
        if(color == 1){

            return Math.min(
                  helper(costs, idx+1, 0, minCost + costs[idx][1]),
                  helper(costs, idx+1, 2, minCost + costs[idx][1])
            );

        }
        if(color == 2){

            return Math.min(
                  helper(costs, idx+1, 0, minCost + costs[idx][2]),
                  helper(costs, idx+1, 1, minCost + costs[idx][2])
            );

        }
           return 99999;
    }
 

    
}




/***
 TC = 3* 2^n --> exponential

 Sc = O(n) --> for recursive stack


 Description : This is a exhasutive Solution. Goining into all possible combinations in a recursive way. Firstly, collecting the minimum cost at every iteraton and finally choosing the minimum cost from all different colors.





 */
 
 
 ----------------------------------------------------------------------------------------------------
 
 
 
 
 //Optimized : (Mutating the Same Array)
 
 
 class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        if(m == 0) return -1;

        for(int i = m-2; i>=0;i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}




---------------------------------------------------------------------------------------------------



class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;
        if(m == 0) return -1;

        int[][] dp = new int[m][n];
        
        dp[m-1][0] = costs[m-1][0]; 
        dp[m-1][1] = costs[m-1][1]; 
        dp[m-1][2] = costs[m-1][2]; 


        for(int i = m-2; i>=0;i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}



/**
Tc : O(m)
Sc : O(n) --> using extra space 



 */
 
 ---------------------------------------------------------------------------------------------------
 
 class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;
        if(m == 0) return -1;

        int[] dp = new int[3];
        
        dp[0] = costs[m-1][0]; 
        dp[1] = costs[m-1][1]; 
        dp[2] = costs[m-1][2]; 


        for(int i = m-2; i>=0;i--){
            int tempR = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
            int tempB = dp[1];
            dp[1] =costs[i][1] + Math.min(tempR, dp[2]);
            dp[2] = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}



/**
Tc : O(m)
Sc : O(1) --> using constant space



 */
