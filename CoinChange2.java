// Time Complexity : O(m*n) where m is the number of coins and n is the total amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class CoinChange2 {
    //Dynamic Prorgamming with space optimization using 1-D Array
    public int change(int amount, int[] coins) {

        //null check
        if (coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;


        int dp[] = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // till amount is not equal to denomination, fill the values as it is from above row
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[n];

    }
}
/* // Dynamic Programming approach usng 2D Array
class Solution{
    public int change(int amount, int[] coins){

        //null check
        if(coins == null || coins.length ==0)
            return 0;

        int m= coins.length;
        int n= amount;

        int[][] dp = new int[m+1][n+1];

        //fill first value with 1 since 0 coins 0 amount can be done in 1 way
        dp[0][0] = 1;

        for(int i=1; i <= m ; i++){
            for(int j=0 ; j <=n ; j++){

                // till amount is not equal to denomination, fill the values as it is from above row
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

*/



/* This is recursive method TC: 2^n where n is number of possibilities in the diagram. This gives Time Limit Exceeded in LC, so we go with DP approach.


class Solution {
    public int change(int amount, int[] coins) {

        //null check
        if(coins == null || coins.length ==0)
            return 0;
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int idx){

        //base case
        if(amount < 0 || idx == coins.length)
            return 0;

        if(amount == 0)
            return 1;

        //logic
        int case1 = helper(coins, amount - coins[idx], idx);

        int case0 = helper(coins, amount, idx+1);

        return case1 + case0;

    }
}

*/
}
