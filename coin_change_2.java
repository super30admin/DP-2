// Time Complexity :O(m * n)
// Space Complexity :O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public int change(int amount, int[] coins) {
    int m = coins.length + 1;
    int n = amount + 1;
    int[][] dp = new int[m][n];
    //Column initialisation
    for(int j = 1; j < n; j++){
        dp[0][j] = 0;
    }
    
    //Row initialisation
    for(int i = 0; i < m; i++){
        dp[i][0] = 1;
    }
    
    //Dynamic programming logic
    for(int i = 1; i < m; i++){
        for(int j = 1; j < n; j++){
            if(j < coins[i - 1]){ //if the amount is less than the coin denomination, we pull the value form the above row
                dp[i][j] = dp[i - 1][j];
            }
            else{
                //we add the cost of choose and don't choose option.
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            }
        }
    }
    return dp[m - 1][n -1];
}