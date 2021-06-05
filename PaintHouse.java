// Time Complexity : O(n) // n is number of houses
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. DP multi dimensional array can be replaced with variables.
 * 2. For every house paint color add its cost and min of last house other two colors cost. 
 * 3. At the end find min of last house three colors.
 * 4. followd bottom u papproach.
 */

public class PaintHouse {
	public int minCost(int[][] costs) {
		
		int noOfHouses = costs.length;
		
		//copy last house as it is
		int costB=costs[noOfHouses-1][0];
		int costG=costs[noOfHouses-1][1];
		int costR=costs[noOfHouses-1][2];

		int costBTmp,costGTmp;
		for (int row = noOfHouses - 2; row >= 0; row--) {
			costBTmp=costB;
			costGTmp=costG;
			
			costB=  costs[row][0] + Math.min(costG, costR);
			costG=  costs[row][1] + Math.min(costBTmp, costR);
			costR=  costs[row][2] + Math.min(costBTmp, costGTmp);
		}
		return Math.min(costB,Math.min(costG,costR));
	}
	
	public static void main(String[] args) {
		int[][] arr= new int[][]{{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(new PaintHouse().minCost(arr));
	}
}
