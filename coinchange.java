//Time complexity is O(amount * n), where n is coins length, amount is given amount
//space complexity is O(amount)
//able to submit in leetcode
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1 ];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]=dp[i-coin]+dp[i];
            }
        }
        return dp[amount];
    }
}