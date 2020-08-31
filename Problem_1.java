
// Time Complexity : O(n * 3) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class Problem_1 {
	
	public int minCost(int[][] costs) {
	        
		if(costs.length == 0) return 0;
        
		int red = costs[0][0];
		int blue = costs[0][1];
		int green = costs[0][2];
		for (int i = 1; i < costs.length; i++) {
			int prevRed = red;
			int prevBlue = blue;
			red = Math.min(blue, green) + costs[i][0];
			blue = Math.min(prevRed, green) + costs[i][1];
			green = Math.min(prevRed, prevBlue) + costs[i][2];
			
		}
		return Math.min(red, Math.min(blue, green));
    }
	
}
