public class problem2 {


// Time Complexity : O(n)
// Space Complexity : O(n*n) n-> number of elements in given array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j] = -1;
            }
        }
       return helper(amount,coins,0,dp);
       
    }
    public int helper(int amount,int[] coins,int index,int[][] dp){
        int ans = 0;
        
        if(amount==0) return 1;
        if(amount<0) return 0;
        if(dp[index][amount]!=-1){return dp[index][amount];}
        
        for(int i=index;i<coins.length;i++){
        int count = helper(amount-coins[i],coins,i,dp);
        ans = ans+count;
        }
        return dp[index][amount]=ans;
    }
}
