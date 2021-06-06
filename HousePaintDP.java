package DP2;
//Time Complexity : o(m*n) - m rows and n cols
//Space Complexity :o(m*n) = m rows and n cols 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//we can choose a color for one house and remaining will be other two colors
//each case for single color and return minimum of all costs.

public class HousePaintDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] costs = {{17,2,17}, {16,16,5}, {14,3,13}};
		
		int minCost = housePaintDP(costs);
		
		System.out.println(minCost);
	}

	private static int housePaintDP(int[][] costs) {
		// TODO Auto-generated method stub
		
		if(costs == null || costs.length == 0) return 0;

	       for(int i = costs.length-2; i>=0; i--)
	       {
	           costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
	           costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
	           costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
	       }
	       
	       return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
	   }
}
