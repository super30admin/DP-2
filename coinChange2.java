// Time Complexity : O (m * n)  where m is number of rows, n is number of columns
// Space Complexity : O (m * n) for the dp matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class coinChange2 {

    public static int coinChangeCombos(int[] coins, int amount){
        if(coins == null || coins.length == 0) return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i- 1][j];
                }else{
                    dp[i][j] = dp[i- 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];


    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        coinChangeCombos(nums, amount);
    }
}
