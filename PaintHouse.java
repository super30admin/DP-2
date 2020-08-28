// TC: O(N) since we are traversing each element in the array in linear fashion.
// SC: O(1) since we are not using any extra space

// If we choose house 0 with red, we will not choose house 1 to paint red, If we choose house 0 to paint with one color, we will choose other colors
// for house 1, we are considering all combinations of subproblems, since there are overlapping sub problems, we store those values, 
// If we choose house 1 for green, we will consider previous house minimum costs to paint the house. Similarly if we have choosen one house, we will
// not adjacent values, we will check only for other index houses other then selected index houses.


public class PaintHouse {
	
	public int Painthouse(int[][] costs) {
		
		return helper(costs, 0,0 ,0);	
	}
	
	public int helper(int[][] costs, int i, int lastChosenIndex, int currentTotalCost) {
		
		//we are overflowing
		if(i==costs.length)
			return currentTotalCost;
		int choseIndex0 = Integer.MAX_VALUE, choseIndex1 = Integer.MAX_VALUE, choseIndex2 = Integer.MAX_VALUE;
		if(lastChosenIndex!=0)
			choseIndex0 = helper(costs, i+1, 0, costs[i][0] + currentTotalCost );
		if(lastChosenIndex!=1)
			choseIndex1 = helper(costs, i+1, 1, costs[i][1] + currentTotalCost);
		if(lastChosenIndex!=2)
			choseIndex2 = helper(costs, i+1, 2, costs[i][2] + currentTotalCost);
		int min1 = Math.min(choseIndex0, choseIndex1);
		return Math.min(choseIndex2, min1);
				
	}
	
	public int paintHouse(int[][] costs) {
		
		if(costs == null || costs.length==0)
			return 0;
		for(int i=1;i<costs.length;i++) {
			
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][2], costs[i-1][0]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
			
		}
		return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
	}
	
	public static void main(String[] args) {
		
		PaintHouse ph = new PaintHouse();
		int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 5, 9}};
		System.out.println(ph.paintHouse(costs));
		
	}

}
