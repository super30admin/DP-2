
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


//Reduced SPace Complx
class Solution {
    public int change(int amount, int[] coins) {
        //null
        if(coins ==  null || coins.length == 0) return 0;
        int m = coins.length; int n = amount;
        int [] dp = new int[n+1];
        
        //By using 1D array
        dp[0] = 1;
        
        for(int i=1; i<= m;  i++){
            for(int j =0; j<=n; j++){

                if(j >=coins[i-1]){
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }


                //or below code we can use
                // if(j<coins[i-1]){ 
                //     dp[j] = dp[j];
                // } 
                // else{
                //     dp[j] = dp[j] + dp[j-coins[i-1]];
                // }
            }
        }

        return dp[n];
        
    }
       
}


// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    public int change(int amount, int[] coins) {
        //null
        if(coins ==  null || coins.length == 0) return 0;
        int m = coins.length; int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        
        //Finding the Number of ways ex: [1,1,1] = for  amount making 3 ==>  1 way ==> but 3 coins
        //ex: [1,1] = for making amount 2 ==>  1 way ==> but 2 coins

        for(int i=1; i<= m;  i++){
            for(int j =0; j<=n; j++){
                if(j<coins[i-1]){
                    
                    dp[i][j] = dp[i-1][j];
                } 
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];   // last value is our number of ways 
    }
       
}




// Time Complexity :  Time Limit Exceeded -> Exponential Solution 
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    public int change(int amount, int[] coins) {
        //null
        if(coins ==  null || coins.length == 0) return 0;
        
        return helper(coins, amount, 0);
    }
    
    private int helper(int [] coins, int amount, int idx){
        //Base
        
        if(amount == 0) return 1;
        
        if(amount< 0 || idx == coins.length) return 0;
        
        //Case1 choose a coin
        int case1 = helper(coins,  amount-coins[idx], idx);
        
        //Case2 don't choose a coin
        int case2 = helper(coins,  amount, idx+1);
        return case1 + case2;
        
        
    }
    
    
}