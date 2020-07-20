// Time Complexity : O(N*T), where N is number of coins and T is the target amount
// Space Complexity : O(N*T), matrix of size NT
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : covering edge cases, if amount is 0 or if coin array is empty


// Your code here along with comments explaining your approach
// We need to return number of ways a target amount can be achieved by adding given coins. Using the dp approach,
// to get number of ways to sum up to target T, I will first sum up to a target P and use the result of that sub problem
// to reach the result for target T. To find the number of ways to reach target P using coins [0,1,2...X],
// I will add up the number of ways to reach P using X-1 coins(not considering Xth coin) and
// the number of ways to reach P-X target using the coin X.


public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (amount == 0 && coins.length == 0) return 1;
        if (coins.length == 0) return 0;

        int row = coins.length + 1;
        int col = amount + 1;
        int memo[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            memo[i][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j < coins[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - coins[i - 1]];
                }
            }
        }

        return memo[row - 1][col - 1];
    }
}
