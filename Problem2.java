// Time Complexity :
//      n - number of houses
//      minCost() - O(n)
//      
// Space Complexity :
//      minCost() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem2 {
	public int minCost(int[][] costs) {
        //edge Case
        if(costs == null || costs.length == 0) return 0;
        
        int m = costs.length;
        
        for(int i=1; i <m; ++i)
        {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(Math.min(costs[m-1][0], costs[m-1][1]), costs[m-1][2]);
    }

}