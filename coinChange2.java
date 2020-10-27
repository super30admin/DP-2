//Time complexity: O(m*n) 
//Space complexity: O(m*n)
//Program ran successfully
/*
    Algorithm: 1. While exploring all sub paths(recursive solution), you can see repeating sub problems
               2. Mapped the recursion tree into the table form
               3. Very similar to the coin change 1 problem
               4. Instead of taking minimum, here we check all possible paths and add them
*/

class coinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
    
        return dp[dp.length-1][dp[0].length-1];
        
    }
}
