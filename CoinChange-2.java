// Time Complexity: O(nm)
// Space Complexity: O(nm) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;//#rows is number of coins + 1
        int m = amount + 1; //#columns is amount + 1
        
        int[][] dp = new int[n][m];//declaring an integer array of size n*m
        
        //initializing an edge condition 
        //i.e, amount 0 can be achieved with coin denomination 0 in one way. 
        dp[0][0] = 1;
        
        //Loop through the dp array
        //if the coin denomintaion is greater the amount you want to match,
        //get the value from previous row same column
        //else add the values from previous row same column and 
        //the value from same row column = current colimn - current coin denomination
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        
        // return the last row and last column of the dp array
        return dp[n-1][m-1];
    }
  }
  
