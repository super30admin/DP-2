// Time Complexity: O(n) - where n is the number of house to be painted 
// Space Complexity: O(1) - Using the existing cost matrix, not creating a new DP matrix

// Approach:
//     The minimum cost of painting the first house is same as that of the first row of cost matrix.
//     From second house onwards, the minimum cost of painting the house will the cost of the paint + minimum cost of painting the previous house
//     The minimum cost would be the minimum amount the last 3 elements of last house(row).

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        //Edge condition
        if(costs == null || costs.length < 1) return 0;
        
        for(int i =1; i<n; i++){
            //Cost of painting red
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
            //Cost of painting blue
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
            //Cost of painting green
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0],costs[i-1][1]);
        }
        
        return Math.min(Math.min(costs[n-1][0], costs[n-1][1]),costs[n-1][2]);
    }
}