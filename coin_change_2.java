// Time Complexity : O(n*m) where n is the amount and n is the length of the coins array (traversing 2-d array of m*n)
// Space Complexity : O(n*m) where n is the amount and n is the length of the coins array (2-d array of m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        
        int m = coins.length;
        int n = amount;
        
        //+1 as we are adding one extra row and column for dummy 0
        int [][]dp = new int[m+1][n+1];
        
        //add 1 to the first row, indicating that there is 1 way to make 0 amount
        //that is by not choosing any coin
        for(int i = 0; i<=m; i++){
            dp[i][0] = 1;
        }
        
        //fill out rest of the grid
        for(int i = 1; i<=m ; i++){
            for(int j=1; j<=n; j++){
                //if j (column index) is less than the current coin
                //copy the value at above index to the current cell
                //Meaning that the current coin cannot be used to make the value
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //the current coin can be used to make the value (one way)
                    //plus add the previous ways possible without choosing this coin
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
//the last call will have all the possible ways to make up the amount
        return dp[m][n];
    }
}