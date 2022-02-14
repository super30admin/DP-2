/*
	Time Complexity : c^h
	Space Complexity: h
*/
class Solution{
	public int paintHouse(int[][] costs, int k){
		int h0r = costs[0][0] + helper(costs, 3, 1, 0);
		int h0g = costs[0][1] + helper(costs, 3, 1, 1);
		int h0b = costs[0][2] + helper(costs, 3, 1, 2);
		return Math.min(h0r, Math.min(h0g, h0b));
	}

	public int helper(int[][] costs, int k, int index, int prevColor){
		if(index == costs.length){
			return Integer.MAX_VALUE;
		}		
	
		if(prevColor==0){
			int hindex1  = costs[index][1] + helper(costs, k, index + 1, 1);
			int hindex2 = costs[index][2] + helper(costs, k, index + 1, 2);
			return Math.min(hindex1, hindex2);
		}

		if(prevColor==1){
			int hindex0  = costs[index][0] + helper(costs, k, index + 1, 0);
			int hindex2 = costs[index][2] + helper(costs, k, index + 1, 2);
			return Math.min(hindex0, hindex2);
		}

		if(prevColor==2){
			int hindex0  = costs[index][0] + helper(costs, k, index + 1, 0);
			int hindex1 = costs[index][2] + helper(costs, k, index + 1, 1);
			return Math.min(hindex0, hindex1);
		}
	}
}
