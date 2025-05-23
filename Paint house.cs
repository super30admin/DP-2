/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on leetcode: yes

  Approach: At each iteration we can have any of the colors with the minimum of the other colors as adjacent. This is a bottom up dynamic programming with constant space complexity.
*/

public class Solution {
    public int MinCost(int[][] costs) {
        var n = costs.Length;
        var dp = new int[3];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;

        for (var i = n-1; i >= 0; i--)
        {
            var temp = new int[3];
            temp[0] = costs[i][0] + Math.Min(dp[1], dp[2]);
            temp[1] = costs[i][1] + Math.Min(dp[0], dp[2]);
            temp[2] = costs[i][2] + Math.Min(dp[0], dp[1]);

            dp = temp;
        }

        return Math.Min(Math.Min(dp[0], dp[1]), dp[2]);
    }
}
