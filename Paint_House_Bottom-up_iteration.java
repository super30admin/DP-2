// Solution: draw the tree, there are 3*N possible states for the problem as each house can have three color possibilities,
// each color has the same children even if it is appeared at multiple occasions.
//TC: O(N)
//SC : O(1)
class Solution {
    public int minCost(int[][] costs) {
        for(int i = costs.length-2; i >=0; i--){

            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1],costs[i+1][0]);


        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}