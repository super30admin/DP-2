//overwriting bottom row to top row eveyt tme , so we can have singl erow of 3 elements , so using 3 variables to store costs 
class Solution {
    public int minCost(int[][] costs) {

        int n = costs.length;
        //set bottom row
       int varR = costs[n-1][0];
       int varB = costs[n-1][1];
        int varG = costs[n-1][2];
        //fill values from last but one row
        for(int i = n-2 ; i>=0 ; i--){
            int tempR = varR;
            varR = costs[i][0] + Math.min(varB, varG);
            int tempB = varB;
            varB = costs[i][1] + Math.min(tempR, varG);
            varG= costs[i][2] + Math.min(tempB, tempR);
        }
        return Math.min(varR , Math.min(varB,varG));
    }
}

// class Solution {
//     public int minCost(int[][] costs) {
//         int n = costs.length;
//         int[][] dp = new int[n][3]; //n rows , 3 colors
//         //set bottom row
//         dp[n-1][0] = costs[n-1][0];
//         dp[n-1][1] = costs[n-1][1];
//         dp[n-1][2] = costs[n-1][2];
//         //fill values from last but one row
//         for(int i = n-2 ; i>=0 ; i--){
//             dp[i][0] = costs[i][0] + Math.min(dp[i+1][1] , dp[i+1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i+1][0] , dp[i+1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i+1][1] , dp[i+1][0]);
//         }
//         return Math.min(dp[0][0] , Math.min(dp[0][1],dp[0][2]));
//     }
// }