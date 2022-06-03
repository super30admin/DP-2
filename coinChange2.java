class Solution {
    //Time complexity:O(m*amount)
    //Space complexity:O(amount)
    public int change(int amount, int[] coins) {
        int m=coins.length+1;
        int n=amount+1;
        int[][] dp=new int[m][n];
        dp[0][0]=0;
        for(int i=1;i<n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }
}