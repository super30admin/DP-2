//Time Complexity : O(2^n)
//Space Complexity : O(n) : Recursion Stack
//Solution accepted on LeetCode, Time Limit Exceeded since it's exhaustive search.

public class Problem1_ExhaustiveSearch {
	
	public int minCost(int[][] costs) {
        
		if(costs == null|| costs.length == 0)
			return -1;
		
		int cost =0;
		int index =0;
		
		//case1 : Choosing first color(0) for house 1.
		int c1 = helper(costs, cost, 0, index);
		
		//case2 : Choosing second color(1) for house 1.
		int c2 = helper(costs, cost, 1, index);
		
		//case3 : Choosing third color(2) for house 1.
		int c3 = helper(costs, cost, 2, index);
		
		return cost = Math.min(c1, Math.min(c2, c3));
    }
	
	private int helper(int[][] costs, int cost, int color, int index) {
		
		if(index == costs.length)
			return cost;
		
		
		if(color == 0) {
			return Math.min(helper(costs,cost+costs[index][color],1,index+1), helper(costs, cost + costs[index][color], 2, index+1));
		}
		if(color == 1) {
			return Math.min(helper(costs,cost+costs[index][color],2,index+1), helper(costs, cost + costs[index][color], 0, index+1));
		}
		if(color == 2) {
			return Math.min(helper(costs,cost+costs[index][color],1,index+1), helper(costs, cost + costs[index][color], 0, index+1));
		}
		
		return -1;
	}

}
