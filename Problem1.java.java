// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1{

public int minCost(int[][] costs) {
        
        int m=costs.length;
        int n=costs[0].length;
        

	// Traverse from bottom up and select the next rows minimum applicable values 		//for the current row
        for(int i=m-2;i>=0;i--)
        {
            costs[i][0]+=Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]+=Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]+=Math.min(costs[i+1][1],costs[i+1][0]);
        }
	
	// Finally select the minumum of the first row
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,costs[0][i]);
        }
        
        return min; 
        
        
        
    }
}