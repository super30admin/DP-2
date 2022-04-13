// Recursive approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0){
            return 0;
        }
        return helper(coins, amount, 0);
    }
    public int helper(int[] coins, int amount, int index){
        //base
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || index == coins.length){
            return 0;
        }
        //logic
        //not choose
        int case1 = helper(coins, amount, index + 1);
        //choose
        int case2 = helper(coins, amount-coins[index], index); 
        return case1 + case2;
    }
}


// DP solution
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length==0){
            return 0;
        }
        int[][]  dp = new int[coins.length + 1][amount + 1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

// m -> coins.length, n -> amount
// Time Complexity : O(m * n)
// Spcae Complexity : O(m * n)