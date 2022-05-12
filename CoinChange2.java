class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null)
            return 0;
        
        int[] dp=new int[amount+1];
       
        for(int i=1;i<=coins.length;i++){
            dp[0]=1;
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    //0 case
                     dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
