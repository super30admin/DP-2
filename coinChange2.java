/**
Time Complexity: O(number of coins*amount)
Space Complexity: O(number of coins*amount)
executed on leetcode: yes
issues faced : none
Approach:
1. intitalize a two dimensional array to store the value of number of ways coins  can be used to reach the target.
2. We are reaching to the target going with each coin seeing whether we should take the coin or not and storing whichever number of  ways that coins can be used.
 */
class coinChange2 {
    public static int change(int amount, int[] coins) {
        if(coins==null) return 0;
        if(amount==0) return 1;
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;++i) dp[i][0] = 1;
        for(int j=1;j<=amount;++j) dp[0][j] = 0;
        for(int i=1;i<=coins.length;++i)
        {
            for(int target=1;target<=amount;++target)
            {
                if(coins[i-1]>target) dp[i][target] = dp[i-1][target];
                else dp[i][target] = dp[i-1][target] + dp[i][target-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }
}