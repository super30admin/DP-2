// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Description: Recursive Solution

class Solution{
	public int minCost(int[][] cost){
		if(costs == null || costs.length==0){
			return 0;
		}
		
		int amount = Integer.MAX_VALUE;
		for(int j=0; j<3; j++){
			amount = Math.min(amount, helper(cost,0,j,0));
		}
		return amount;
	}
	
	private int helper(int[][] costs, int i, int j, int amount){
		//base case
		if(i== costs.length){
			return amount;
		}
		
		int case1 =0, case2 = 0;
		if(j==0){
			case1 += helper(costs, i+1, 1, amount +costs[i][1]);
			case2 += helper(costs, i+1, 2, amount +costs[i][2]);
		}
		if(j==1){
			case1 += helper(costs, i+1, 0, amount +costs[i][0]);
			case2 += helper(costs, i+1, 2, amount +costs[i][2]);
		}
		if(j==2){
			case1 += helper(costs, i+1, 0, amount +costs[i][0]);
			case2 += helper(costs, i+1, 1, amount +costs[i][1]);
		}
		
		return Mat.min(case1, case2);
	}
}


// Time Complexity : O(3n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Description: DP Solution, modifying the original array to save space
class Solution{
	public int minCost(int[][] cost){
		if(costs == null || costs.length==0){
			return 0;
		}
		
		int lastR = costs[0][0];
		int lastB = costs[0][1];
		int lastG = costs[0][2];
		
		for(int i=0; i< costs.length ; i++){
			int currR = costs[i][0] + Math.min(lastB, lastG);
			int currB = costs[i][1] + Math.min(lastR, lastG);
			int currG = costs[i][2] + Math.min(lastR, lastB);
		}
		
		return Mat.min(lastR, Math.min(lastB, lastG));
	}
}
