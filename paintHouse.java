// Time Complexity : O(n) , n is number of houses
// Space Complexity : O(n*3) , n is number of houses
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


class Solution {
	public int costMin (int[][] costs) {
		if(costs == null || costs.length == 0) return 0;
		for (int i = 1; i < costs.length; i++) { //for 0th house, returns directly comparing the costs for all three colors
		    cost[i][0] = cost[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);//if ith house is colored red, then pick color for i-1 house with min cost
		    cost[i][1] = cost[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);// similarly for blue
		    cost[i][2] = cost[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);// similarly for green
		} 
		return Math.min(costs[costs.length-1][0],costs[costs.length-1][1], costs[costs.length-1][2]); //return minimum cost out of the three colors
	}
}

