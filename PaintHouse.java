package s30Coding;

// Time Complexity :- O(n)  - traversing through all the elements of each row once
// Space Complexity :- O(1) - no extra space used

// Leet Code :- Yes

// Logic :- I have used bottom-up approach. Start with the second last row in the matrix, find the totalCost of each
//			color by taking the minimum of n+1 row's adjacent colors, adding it to current nth element and move up. At the end return the minimum totalCost
// 			between all the elements of the first row and that is your minimum cost

public class PaintHouse {

	public int totalCost(int[][] costs) {
		if(costs.length == 0 || costs == null) {
			return 0;
		}
		for(int i = costs.length -2; i>=0; i--) {
			costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2] );
			
			costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2] );
			
			costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1] );
		}
		return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2] ));
	}
}
