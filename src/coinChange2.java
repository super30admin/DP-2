public class coinChange2 {
   //Brute

    // Time Complexity : O(2^MN)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    class Solution {
        public int change(int amount, int[] coins) {
            if(coins == null) return 0;

            return helper(amount, coins, 0);
        }

        private int helper(int amount, int coins[], int index) {
            //base
            if(amount == 0) return 1;
            if(amount<0 || index>=coins.length) return 0;
            //logic
            int case1 = helper(amount-coins[index], coins,index);
            int case0 = helper(amount, coins, index+1);
            return case1+case0;
        }
    }

    // DP
    // Time Complexity : O(MN)
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    public int change(int amount, int[] coins) {
            if(coins == null) return 0;
            int dp[][] = new int[coins.length+1][amount+1];
            for(int i = 0; i <dp.length; i++) {
                dp[i][0] = 1;
            }
            for(int i=1; i < dp.length; i++) {
                for(int j=1; j < dp[0].length; j++) {
                    if(j < coins[i-1]) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1];
        }
}
