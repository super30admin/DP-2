// Time Complexity : O(m*n) where m is no. of colors and n is houses
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
The problem requires painting houses with three color choices while ensuring that no two adjacent houses have the same color. The goal is to minimize the total painting cost.

### **Intuition:**
The key idea is that the cost of painting a house depends on the choices made for subsequent houses. Instead of making decisions greedily for each house, we use **dynamic programming** to systematically compute the minimum cost by considering optimal subproblems.

### **Logic:**
We solve this problem **bottom-up**, starting from the last house and moving toward the first. At each house, we decide the best color to paint it by considering the **minimum cost** from the next house’s available color choices.

- If a house is painted **red**, the next house must be either **blue** or **green**. Thus, the cost for painting the current house red is the **current cost of red + the minimum cost of painting the next house either blue or green**.
- Similarly, if a house is painted **blue**, its cost is the **current cost of blue + the minimum cost of the next house painted either red or green**.
- The same applies to painting the house **green**.

By iterating over all houses in this manner, we ensure that each house is optimally painted while satisfying the constraint of no two adjacent houses having the same color. Finally, the answer is the minimum among the three possible costs of painting the first house.

This approach efficiently finds the minimum painting cost while ensuring that constraints are met, making it an **optimal and systematic** solution.

*/
class PaintHouse {
    public int minCost(int[][] costs) {
        int m=costs.length;
        int n=costs[0].length;

        int[][] dp=new int[m][n];

        dp[m-1][0]=costs[m-1][0];
        dp[m-1][1]=costs[m-1][1];
        dp[m-1][2]=costs[m-1][2];

        for(int i=m-2;i>=0;i--)
        {
            dp[i][0]=costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
        }

        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}