class Solution {
    //int count;
    public int change(int amount, int[] coins) {
        //dp matrix using 1d array/matrix
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=0; j<=n;j++){
                if(j < coins[i-1]){
                    dp[j] = dp[j];
                } else{
                dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];


/*
        //dp matrix using 2d array/matrix
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=0; j<=n;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else{
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
*/
/*
        //return type based recursion
        return helper(coins, 0, amount);
*/

/*
        //void based recursion
        this.count =0;
        helper(coins, 0, amount);
        return count;
        */
    }

    /*
     //return type based recursion
     private int helper(int[] coins, int i, int amount){
        //base case
        if(amount == 0){
            return 1;
        }

        if(amount < 0 || i == coins.length) return 0;


        //dont choose
        int case0 = helper(coins, i+1, amount);


        //choose
        int case1 = helper(coins, i , amount-coins[i]);

        return case0+case1;
    }
*/
/*
    //void based recursion
    private void helper(int[] coins, int i, int amount){
        //base case
        if(amount == 0){
            count++;
            return;
        }

        if(amount < 0 || i == coins.length) return;


        //dont choose
        helper(coins, i+1, amount);


        //choose
        helper(coins, i , amount-coins[i]);
    }
    */
}
