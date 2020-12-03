// Time Complexity :  O(N), N-> number of houses
// Space Complexity : O(1), since we didn't use any auxiliary space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PaintHouse{
	
	public int minCost(int[][] costs) {
		//checking whether costs input is empty or not		
		if(costs==null || costs.length==0) {
			return 0;
		}
		
		int rows = costs.length;
		
        //for the houses apart from the first house, we are computing the minimum among the previous rows (not in adjacent) and adding it to current value
		for(int i=1;i<rows;i++) {
			costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
		    costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
			
		}
		//finally returning the minimum values among the elements in th last row
		return Math.min(costs[rows-1][0], Math.min(costs[rows-1][1], costs[rows-1][2]));
	}
	
	public static void main(String[] args) {
		PaintHouse ob = new PaintHouse();
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(ob.minCost(costs));
	}
}