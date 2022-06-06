public class CoinChange2 {

    //Time Complexity-O(mn)
    //Space Complexity-O(mn)
    public int change(int amount, int[] coins) {

        if(coins==null || coins.length==0) return 0;
        int n=amount;
        int m=coins.length;

        int [][] dp=new int[m+1][n+1];

        dp[0][0]=1;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}
