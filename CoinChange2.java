public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        if(coins==null||coins.length==0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        // no need to do because default is zero: just for ref
        for(int j=1;j<=n;j++){
            dp[0][j] = 0;
        }
        for(int i = 1;i<=m;i++){
            for(int j=0;j<=n;j++){
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

    public static void main(String[] args) {
        System.out.println(CoinChange2.change(5,new int[]{1,2,5}));
    }
}
