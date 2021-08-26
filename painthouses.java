// Time Complexity: O(n) where n is number of houses.
// Space Complexity: O(1), we have updated existing matrix to provide minimum values at top row, we can perform the same with O(n) by creating a new matrix
// Did you complete it at leetcode: Yes
// Any problems faced: in O(n) solution Incorrectly chose limit of j for filling in dp matrix with cost matrix to dp.length rather than 3, causing test case failure.

// Write your approach here:
// Idea is to use the solved subproblems at the end of the matrix and calculate the minimum amount for painting till the 1st house is reached
// To perform that we are updating existing matrix with all houses except last house value to be summation of current house color and minimum cost of possible colors for next house which is already calculated. By updating minimum values for each house bottom up
// we just need to find minimum at the house 1 that what is minimum possible cost to color all houses according to condition.
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) {
            return 0;
        }
        for(int i= costs.length-2; i>=0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}