package dp2;

public class PaintHouse {
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Used yesterday's technique from class
	public int minCost(int[][] costs) {
        int[] row = costs[costs.length - 1];
        
        for(int i=costs.length - 2; i>=0; i--) {
            int[] currRow = costs[i];
            currRow[0] += Math.min(row[1], row[2]);
            currRow[1] += Math.min(row[0], row[2]);
            currRow[2] += Math.min(row[0], row[1]);
            row = currRow;
        }
        
        return Math.min(row[0], Math.min(row[1], row[2]));
    }
	
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	//Modifying the input array
	public int minCost1(int[][] costs) {
        for(int i=costs.length - 2; i>=0; i--) {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
	
	//Recursion
	//Time Complexity - O(2^n) - TLE
	public int minCost2(int[][] costs) {
        return Math.min(helper(0, 0, costs), Math.min(helper(0, 1, costs), helper(0, 2, costs)));
    }
    
    private int helper(int index, int color, int[][] costs) {
        int totalCost = costs[index][color];
        
        if(index == costs.length - 1) {
            
        } else if(color == 0) {
            totalCost += Math.min(helper(index + 1, 1, costs), helper(index + 1, 2, costs));
        } else if(color == 1) {
            totalCost += Math.min(helper(index + 1, 0, costs), helper(index + 1, 2, costs));
        } else if(color == 2) {
            totalCost += Math.min(helper(index + 1, 0, costs), helper(index + 1, 1, costs));
        }
        
        return totalCost;
    }
}
