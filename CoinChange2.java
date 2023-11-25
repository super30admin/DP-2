//Time complexity = O(n)
//Space Complexity = O(n)
class Solution {
    public int change(int amount, int[] coins) {
         int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
            {
                if(j< coins[i-1])
                    dp[j] = dp[j];
                else
                    dp[j] = dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[n];
    }
}
/*
 * class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins,amount,0);
    }
    private int helper(int[] coins,int amount, int index){
        //base case
        if(amount == 0) return 1;

        if(amount<0 || index == coins.length) return 0;
        //no choose
        int nochoose = helper(coins,amount,index+1);
        //choose
        int choose = helper(coins,amount-coins[index],index);

        return choose+nochoose;
    }
}
 */
