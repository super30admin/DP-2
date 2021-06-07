// Time Complexity:  Exponential as at each stage we will decide to choose between two options only

class Solution{
	public int minCost(int[][] costs){
		

		int case1 = helper(costs,0,0,0);
		int case2 = helper(costs,0,1,0);
		int case3 = helper(costs,0,2,0);
	}

	private helper(int[][] costs, int row, int color, int result){

		//base 

		if(row == costs.length) return result;

		//logic
		if(color == 0){
			return Math.min(helper(costs, row+1, 1, result + costs[row][0]),
							helper(costs, row+1, 2, result + costs[row][0]));
		}
		if(color == 1){
			return Math.min(helper(costs, row+1, 0, result + costs[row][1]),
							helper(costs, row+1, 2, result + costs[row][1]));
		}
		if(color == 2){
			return Math.min(helper(costs, row+1, 0, result + costs[row][2]),
							helper(costs, row+1, 1, result + costs[row][2]));
		}

		return 1490; 
	}
}