class Solution {
    public int change(int amount, int[] coins) {
     
         int []  dp = new int[amount+1];
   
        Arrays.fill(dp, 0);
        dp[0]=1;
     
    for(int i=0;i<=coins.length-1;i++)
    {
        for(int j=coins[i];j<=amount;j++)
        {
            dp[j]+=dp[j-coins[i]];
        }
    }
        int result=dp[amount];
        return result;
    }
}