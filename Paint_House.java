// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Paint_House {
	public static int minCosts(int[][] costs) {
		if(costs == null || costs.length == 0)
			return 0;
		
		for(int i=1; i<costs.length; i++) {
			costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);		//choose red, take the min from previous row green and blue and add to current value
			costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);		//choose green, take the min from previous row red and blue and add to current value
			costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);		//choose blue, take the min from previous row red and green and add to current value
		}
		
		
		return Math.min(Math.min(costs[costs.length -1][0], costs[costs.length -1][1]), costs[costs.length-1][2]); // return min of last row
	}

	public static void main(String[] args) {
		int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
		System.out.print(minCosts(costs));

	}

}
