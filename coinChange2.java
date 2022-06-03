// Time Complexity : O(nt) where t = amount
// Space Complexity : O(nt)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    public static int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;
        // dp table
        int[][] dp = new int[m + 1][n + 1];

        // base case
        // initlially dp[0][0] would be 1 because we can make 0 amount with the help of
        // 0 denomination
        dp[0][0] = 1;

        // here we are traverse throught dp table and set a logic how from the
        // previously counted values we can get current values

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // from my logic if j (amount) < current denomination coin we can get current
                // values from previous row only
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // else current value is equal to previous row value plus in value current row
                    // that
                    // is current column minus denomination coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println("number of possible combinations: " + change(amount, coins));
    }
}