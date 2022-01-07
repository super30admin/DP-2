//Paint House
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public int minCost(int[][] costs) {
    
        if(costs ==  null || costs.length == 0){
            return 0;
        }
        
        for(int i  = costs.length - 2; i >= 0 ; i--){
            costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);
        }
        
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
     
}
}

//---------------------------------------------------------------------//
//Coin Change 2
// Time Complexity : O(n * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
class Solution {
    public int change(int amount, int[] coins) {
        
        //null
        if(coins == null) return 0;
        
        int [][]dp = new int[coins.length + 1][amount + 1];
        
        
        //first col 1 always
        for(int i =0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //case 1 available till amt < denomination
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
        
   
    }
}