//TC: O(M*N)
//SC: O(N) - amount
class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];

        Arrays.fill(dp,0);
        // dp[1][0] = 1;
        for(int i =1; i <= coins.length; i++){
            for(int j =0; j<= amount; j++){
                if(j==0)dp[j] = 1;
                else{
                    if(j>= coins[i-1]){
                        dp[j] += dp[j-coins[i-1]];
                    }
                }
            }
        }
        return dp[amount];

    }
}