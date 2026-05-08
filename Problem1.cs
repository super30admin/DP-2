// Time Complexity : O(n) where m is the total length of costs array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution
{
    public int MinCost(int[][] costs)
    {
        int rows = costs.Length;

        for (int i = 1; i < rows; i++)
        {
            costs[i][0] += Math.Min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.Min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.Min(costs[i - 1][1], costs[i - 1][0]);
        }

        return Math.Min(Math.Min(costs[rows - 1][0], costs[rows - 1][1]), costs[rows - 1][2]);
    }
}