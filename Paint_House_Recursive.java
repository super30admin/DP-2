// Time Complexity :O(3 * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Paint_House_Recursive {
	public static int minCosts(int[][] costs) {
		int case1 = helper(costs, 0, 0, 0);
		int case2 = helper(costs, 0, 0, 1);
		int case3 = helper(costs, 0, 0, 2);
		return Math.min(case1, Math.min(case2, case3));
		
	}
	
	public static int helper(int[][] costs, int min, int row, int prevColor) {
		int case1 = Integer.MAX_VALUE;
		int case2 = Integer.MAX_VALUE;
		int case3 = Integer.MAX_VALUE;
		
		if(row == costs.length)
			return min;
		
		//case1 == choose red
		if(prevColor == 0) {
			case1 = Math.min(
					helper(costs, min+costs[row][1], row+1, 1), 	//blue
					helper(costs, min+costs[row][2], row+1, 2)		//green
					);
		}
		
		//case2 == choose blue
		if(prevColor == 1) {
			case2 = Math.min(
					helper(costs, min+costs[row][0], row+1, 0), 	//red
					helper(costs, min+costs[row][2], row+1, 2)		//green
					);
		}
		
		//case3 == choose green
		if(prevColor == 2) {
			case3 = Math.min(
					helper(costs, min+costs[row][0], row+1, 0), 	//red
					helper(costs, min+costs[row][1], row+1, 1)		//blue
			);
		}
		
		return Math.min(case1, Math.min(case2, case3));		
	}

	public static void main(String[] args) {
		int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
		System.out.print(minCosts(costs));

	}

}
