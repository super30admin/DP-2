// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
//Approach: In this approach since the greedy doesnt work and we have same repeated problems we take a dp matrix because we have 2 input variables.
//For the first row we add a 0 in all the columns. Then we check if the denomination is greater than the columns index,
//we just take the previous entry. Otherwise we add the previous entry and the entry at whatever at denomination steps back.
// Finally we return the last entry as answer.

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null)return 0;
        int m = coins.length;
        int n = amount;
        int [][] dp= new int[m+1][n+1];

        dp[0][0] =1;

        for(int j=1;j<=n;j++){
            dp[0][j] = 0;
        }
        for(int j=1;j<=m;j++){
            dp[j][0] = 1;
        }

        for(int i=1; i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }  
            }
        }
        if(amount <0)return 0;
        return dp[m][n];
    }
}


//Recursive solution
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)return 0;
        return helper(coins,amount,0);
    }

    private int helper(int[] coins, int amount, int idx){
        //base
        if(amount <0 || idx == coins.length)return 0;
        if(amount ==0) return 1;
        //logic
        //not choose
        int case1 = helper(coins,amount, idx+1);
        //choose
        int case2 =helper(coins,amount-coins[idx],idx);
        return case1 + case2;
    }
}