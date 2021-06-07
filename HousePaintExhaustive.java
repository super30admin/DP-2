// Time Complexity : O(2 pow n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution{
	public int minCost(int[][] costs){
		int case1 = helper(costs,0,0,0); //when first house is painted red
		int case2 = helper(costs,0,1,0); //when first house is painted blue
		int case3 = helper(costs,0,2,0); //when first house is painted green

        Math.min(case1,Math.min(case2,case3));
	}

	private helper(int[][] costs, int row, int color, int result){
		//base 
		if(row == costs.length) return result;

		//current house is red
		if(color == 0){
			return Math.min(helper(costs, row+1, 1, result + costs[row][0]),
							helper(costs, row+1, 2, result + costs[row][0]));
		}
        //current house is blue
		if(color == 1){
			return Math.min(helper(costs, row+1, 0, result + costs[row][1]),
							helper(costs, row+1, 2, result + costs[row][1]));
		}
        //current house is green
		if(color == 2){
			return Math.min(helper(costs, row+1, 0, result + costs[row][2]),
							helper(costs, row+1, 1, result + costs[row][2]));
		}

		return 9999; 
	}
}