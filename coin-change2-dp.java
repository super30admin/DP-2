//Time complexity: O(M*N)
//Space complexity: O(M*N)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        //We can make 0 amount with each coins.
        //so first column will be 1
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;    
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                //Till the amount column is less than amount - 1, we will use the
                //value from the above row above column
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                //else we will add the value of above row above column and value which is at current row and column j - coins[i-1]
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}