// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// The basic idea is to select every color and calculate the minimum cost for that one combination
// Also notice that two adjacent houses should not have the same color
// Finally return the minimum cost of painting all the houses
class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}