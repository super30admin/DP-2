class Solution {
    //recusion approach- exhaustive
    public int change(int amount, int[] coins) {
        if(coins.length==0 || coins==null) return -1;
        return recurse(coins, amount,0);
    }
    private int recurse(int[] coins, int amount, int index){
        //base
        if(index == coins.length || amount < 0 ) return 0;
        if(amount==0) return 1;
        //case0
        int case0 = recurse(coins, amount,index+1);
        //case1
        int case1 = recurse(coins, amount-coins[index], index);

        return case0 + case1;


    }



    //dp approach
    public int change(int amount, int[] coins) {
        //if(coins.length==0 || coins==null) return -1;
        int n = coins.length;
        int m = amount;
        int[][] dp=new int[n+1][m+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                //denomination > amount
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //case0 + case1
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][m];

    }

}