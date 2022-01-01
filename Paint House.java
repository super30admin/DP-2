// Time Complexity : O(n) where n = number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
                
        // start to mutate the costs matrix from second last row
        // to get the second last row, take the minimum of the last(next) row's other two color costs
        
        for(int i = costs.length - 2; i>= 0; i--){
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        
        // return the minimum of the first row to get the minimum color cost
        return Math.min( costs[0][0], Math.min(costs[0][1], costs[0][2]) ) ;
    }
}