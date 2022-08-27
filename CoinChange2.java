/**
## Problem2 (https://leetcode.com/problems/coin-change-2/)
 
Time Complexity :   O (M * N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (518. Coin Change 2)
Any problem you faced while coding this :       No
 */

 class CoinChange2 {
    public int change(int amount, int[] coins) {
        // Edge case validation
        if ( coins == null || coins.length == 0){
            return 0;
        }
        int m = coins.length;
        int n = amount;
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                // when demonnation greater than coin
                if(j >= coins[i-1]){
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        // return last item (number of combinations)
        return dp[n];
    }
    
    public static void main(String args[]) 
    { 
        CoinChange2 obj = new CoinChange2();
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(obj.change(amount, coins));
    }
}