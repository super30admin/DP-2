// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length==0) return -1;
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for( int i=1;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for( int i = 1; i< dp.length;i++){
            for( int j=0;j<dp[0].length;j++){
                if(j<coins[i-1]){ // coin[i-1] bcoz dp has 0,1,2,5 and coins array has 1,2,5
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
    
//     public int change(int amount, int[] coins) {
//         //method1 brute force
//         if(coins == null)return 0;
//         return helper(coins,amount,0);
//     }
//     private int helper(int[] coins, int amount, int index){
//         //base
//          if(amount==0)return 1;
            
//          if(amount<0 || index == coins.length) return 0;
        
//         //logic
//         //choose
//         int case1 = helper(coins, amount-coins[index], index);
//         //not choose
//         int case2 = helper(coins,amount, index+1);
//         return case1+case2;
//     }
}