// TC: O(n) SC: O(n)
// Ran on Leetcode: Yes
/* 
For each color we add the current house cost and the min of adj house with different colors. 
*/
class Solution1 {
    public int minCost(int[][] costs) {
        int rLen = costs.length;
        int cLen = costs[0].length;
        int dp[][] = new int[rLen][cLen];
        // Last row
        for(int i = 0; i < cLen; i++){
            dp[rLen - 1][i] = costs[rLen - 1][i];
        }

        for(int i = rLen - 2; i >= 0; i--){
            for(int j = 0; j < cLen; j++){
                if(j == 0){ //Red
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j + 1], dp[i + 1][j + 2]);
                }
                else if(j == 1){ //Blue
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]);
                } else { //Green
                    dp[i][j] = costs[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j - 2]);
                }
            }
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}