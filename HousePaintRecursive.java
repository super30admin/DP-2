package DP2;
//Time Complexity : o(2^n) - m rows and n cols
//Space Complexity :o(n) = m rows and n cols 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//we can choose a color for one house and remaining will be other two colors
//each case for single color and return minimum of all costs.

public class HousePaintRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] costs = {{17,2,17}, {16,16,5}, {14,3,13}};
		
		int minCost = housePaintRecursive(costs);
		
		System.out.println(minCost);
	}

	private static int housePaintRecursive(int[][] costs) {
		// TODO Auto-generated method stub
		
		if(costs == null || costs.length == 0) return 0;
		//case1 - color R
		int case1 = helper(costs,0,0,0);
		//case1 - color B
		int case2 = helper(costs,1,0,0);
		//case1 - color G
		int case3 = helper(costs,2,0,0);
		
		return Math.min(case1, Math.min(case2, case3));
	}

	private static int helper(int[][] costs, int color, int row, int minCost) {
		// TODO Auto-generated method stub
		//base case
		if(row == costs.length) return minCost;
		//logic
		if(color ==0) {
			return Math.min(helper(costs,1,row+1,minCost+costs[row][0]), helper(costs,2,row+1,minCost+costs[row][0]));
		}else if(color ==1) {
			return Math.min(helper(costs,0,row+1,minCost+costs[row][1]), helper(costs,2,row+1,minCost+costs[row][1]));
		}else {
			return Math.min(helper(costs,0,row+1,minCost+costs[row][2]), helper(costs,1,row+1,minCost+costs[row][2]));
		}
	}

}
