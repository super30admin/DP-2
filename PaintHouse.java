// Time Complexity : O(n)
// Space Complexity : O(1)
public class PaintHouse {
	public int minCost(int[][] costs) {
		if(costs==null || costs.length==0) return 0;
		
		//DP- Bottom Up
		for(int i=costs.length-2; i>=0; i--) {
			//Choose Red
			costs[i][0]=costs[i][0]+ Math.min(costs[i+1][1], costs[i+1][2]);
			//Choose Blue
			costs[i][1]=costs[i][1]+ Math.min(costs[i+1][0], costs[i+1][2]);
			//Choose Green
			costs[i][2]=costs[i][2]+ Math.min(costs[i+1][0], costs[i+1][1]);
		}
		
		//Final result is min of cumulative sum in first row.
		return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
	}
	
	public static void main(String[] args) {
		PaintHouse ob= new PaintHouse();
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println("Min cost to paint all the houses is :"+ ob.minCost(costs));
	}
}
