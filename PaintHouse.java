
public class PaintHouse {
	/*//Recursive approach
	 public static int minCost(int[][] costs){
		if(costs == null || costs.length == 0) return 0;
		int caseR = helper(costs, 0, 0, 0);
		int caseG = helper(costs, 0, 1, 0);
		int caseB = helper(costs, 0, 2, 0);
		return Math.min(caseR, Math.min(caseG, caseB));
	}
	
	private static int helper(int[][] costs, int row, int color, int min){
		//base
		if(row == costs.length) return min;
		//logic
		if(color == 0){
			return Math.min(
					helper(costs, row + 1, 1, min + costs[row][0]),
					helper(costs, row + 1, 2, min + costs[row][0])
			);
		}
		if(color == 1){
			return Math.min(
					helper(costs, row + 1, 0, min + costs[row][1]),
					helper(costs, row + 1, 2, min + costs[row][1])
			);
		}
		return Math.min(
				helper(costs, row + 1, 0, min + costs[row][2]),
				helper(costs, row + 1, 1, min + costs[row][2])
		);
	}
	*/
	
	/*//using DP by manipulating the same matrix
	public static int minCost(int[][] costs){
		if(costs == null || costs.length == 0) return 0;
		for(int i = costs.length-2; i>=0; i--){
			costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
		}
		return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
	}
	*/
	
	//using dp but not manipulating the same matrix
	public static int minCost(int[][] costs){
		if(costs == null || costs.length == 0) return 0;
		int cRed = costs[costs.length-1][0];
		int cGreen = costs[costs.length-1][1];
		int cBlue = costs[costs.length-1][2];
		for(int i = costs.length-2; i>=0; i--){
			int tempR = cRed;
			int tempG = cGreen;
			int tempB = cBlue;
			cRed = costs[i][0] + Math.min(tempG, tempB);
			cGreen = costs[i][1] + Math.min(tempR, tempB);
			cBlue = costs[i][2] + Math.min(tempR, tempG);
		}
		return Math.min(cRed, Math.min(cGreen, cBlue));
	}
	
	public static void main(String[] args) {
		int[][] costs = {{1,2,3},{4,2,6},{8,8,9},{10,1,12}};
		System.out.println(PaintHouse.minCost(costs));
	}
	
	
	
}
