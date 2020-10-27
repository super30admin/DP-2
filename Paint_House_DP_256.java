//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : This problem is locked
//Any problem you faced while coding this : 


class Paint_House_DP_256 {
	int minCost(int[][] costs) {
		if(costs == null || costs.length == 0)
			return 0;
		int n = costs.length;
		int redCost = 0;
		int blueCost = 0;
		int greenCost = 0;
		
		for(int i = 0; i < n; i++)
		{
			int tempB = blueCost;
			int tempR = redCost;
			blueCost  = costs[i][0] + Math.min(redCost, greenCost);
			redCost   = costs[i][1] + Math.min(tempB, greenCost);
			greenCost = costs[i][2] + Math.min(tempB, tempR);
		}
		return (Math.min(blueCost, Math.min(redCost, greenCost)));
	}
	
	public static void main(String[] args)
	{
		Paint_House_DP_256 paint = new Paint_House_DP_256();
		int[][] costs = {{12,5,16}, {1,20,10}, {3,12,19}};
		
		System.out.println(paint.minCost(costs));
	}
}
