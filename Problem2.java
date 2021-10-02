// Time Complexity : O(N * S)
// Space Complexity : O(S)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i : coins)
            for (int j = i; j <= amount; ++j)
                dp[j] += dp[j-i];

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

}
