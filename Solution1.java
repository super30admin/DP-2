// Leetcode Problem : https://leetcode.com/problems/paint-house/
// Time Complexity : O(3n) where n is the number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I start iterating from the second row of the costs matrix. For the element in first column,
 * I replace the value as the sum of cost at that position + minimum of cost at previous row
 * but second and third columns(so that colors aren't repeated). Similarly, 
 * costs[i][1]+=Math.min(costs[i-1][2],costs[i-1][0]) and costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
 */

class Solution {
    public int minCost(int[][] costs) {
        for(int i=1;i<costs.length;i++)
        {
            
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][2],costs[i-1][0]);
            costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
            
        }
        return Math.min(Math.min(costs[costs.length-1][0],costs[costs.length-1][1]),costs[costs.length-1][2]);
    }
}