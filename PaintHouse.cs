// Time Complexity : O(m*3) => O(m) 3 is constant number of colors
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Didnt tried, premium question, dont have access
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//https://leetcode.com/problems/paint-house/
public int minCost(int[][] costs) {
    if(costs == null || costs.Length == 0)
        return 0;

    for(int i = costs.Length - 2; i >= 0; i++)
    {
        costs[i][0] += Math.Min(costs[i+1][1], costs[i+1][2]);
        costs[i][1] += Math.Min(costs[i+1][0], costs[i+1][1]);
        costs[i][2] += Math.Min(costs[i+1][0], costs[i+1][1]);
    }
    return Math.Min(costs[0][0], costs[0][1], costs[0][2]);
}





//this solution will have O(2^n), tieme limeit exceeded
public int minCost(int[][] costs) {
    if(costs == null || costs.Length == 0)
        return 0;

    int case1 = helper(costs, 0, 0, 0);
    int case2 = helper(costs, 1, 0, 0);
    int case3 = helper(costs, 2, 0, 0);

    return Math.Min(case1, Math.Min(case2, case3));
}

private int helper(int[][] costs, int color, int row, int totalCost)
{
    //base
    if(row == costs.Length)
        return totalCost;

    //logic
    if(color == 0)
    {
        return Math.Min(helper(costs, 1, row+1, totalCost + costs[row][0]), helper(costs, 2, row+1, totalCost + costs[row][0]));
    }
    if(color == 1)
    {
        return Math.Min(helper(costs, 0, row+1, totalCost + costs[row][1]), helper(costs, 2, row+1, totalCost + costs[row][1]));
    }
    if(color == 2)
    {
        return Math.Min(helper(costs, 0, row+1, totalCost + costs[row][2]), helper(costs, 1, row+1, totalCost + costs[row][2]));
    }
    //it should never come here
    return 43245325;
}