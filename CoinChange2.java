//Time: O(N×amount)
//Space: O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int [coins.length][amount+1]; 
        for(int[]x:dp){Arrays.fill(x,-1);}
        return helper(0,coins,amount,dp);
       
    }
    
    
    public int helper(int x, int[]coins, int amount, int [][]dp){
        
        if(x>coins.length-1||amount<0){ return 0;}
        
        if(amount==0){ return 1; }
        if(dp[x][amount]!=-1){return dp[x][amount];}
        int a=helper(x,coins,amount-coins[x],dp);
        int b=helper(x+1,coins,amount,dp);
        return dp[x][amount]=a+b;
    }
}
