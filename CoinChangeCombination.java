// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Since there are repeated sub problems  we can use DP with 2D MAtrix as there are 2 deciding factors when you look at the base case which is amount and coins denomination


///using DP
//lets consider 2D matrix with row being amount and column being the coin denomination and the cell represents the no. of combinations
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length ==0 ) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        //since the first column values will be 1 as with 0 amount you can have oly 1 combination 
        for(int i = 0; i < m + 1 ; i++){
            dp[i][0]= 1;
        }
        for(int i = 1; i <  m + 1; i++){
            for (int j = 1 ;j < n + 1 ; j++){
                if(j < coins[i - 1]){
                //only 0 case (not choose) is possible
                dp[i][j] = dp[i - 1][j];
                }
                else{
                    //add both 0 case and 1 case
                     dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
return dp[m][n];
    }
}

// Time Complexity : 2^n (Exponential)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes (time limit exceeded)


// Your code here along with comments explaining your approach
//Exhaustive approach using recursion
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length ==0 ) return 0;
        return helper(coins,amount,0);
    }
    private int helper(int[] coins, int amount, int index){
        //base case when the amount is -ve and index out of bounds
        if(index == coins.length || amount < 0){
            return 0;
        }
        if(amount ==0 ){
            return 1;
        }
        //logic
        //do not choose
        int case1 = helper(coins,amount,index+1);
        //choose
        int case2 = helper(coins,amount - coins[index],index);
        return case1 + case2;
    }
}