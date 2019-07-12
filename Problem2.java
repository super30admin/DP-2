// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length < 1){ //base case: empty array
            return amount == 0 ? 1 : 0;
        }
        Arrays.sort(coins);
        if(amount < coins[0]){ //base case: amount is less than smallest denomination
            return 1;
        }
        int[] dp = new int[amount+1]; 
        for(int i=0; i<coins.length; i++){
            for(int j = coins[i]; j<=amount; j++){
                if(j == coins[i]){
                    dp[j] += dp[j - coins[i]] + 1;
                }else{
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
