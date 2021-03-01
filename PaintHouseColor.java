// Time Complexity :O(costs.length)
// Space Complexity :O(1) for 3rd solution
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



public class PaintHouseColor {
	public static void main(String[] args){
		PaintHouseColor paintHouseColor = new PaintHouseColor();
		int[][] nums = new int[][]{{5,20,30},{20,5,30},{0,20,5}};
		if(nums == null || nums.length == 0) return;
		System.out.println(paintHouseColor.helper1(nums, 0, false, false, false, 0));
		System.out.println(paintHouseColor.helper2(nums));
		System.out.println(paintHouseColor.helper3(nums));
	}
	
	private int helper1(int[][] nums, int i, boolean skipRed, boolean skipGreen, boolean skipBlue, int cost){//exponential Time Complexity constant space
		//Base Case
		if( nums == null || i == nums.length) {
			return cost;
		}
		int case1 = 999999, case2 = 999999, case3 = 999999;
		//Core Logic
		if(!skipRed)
			case1 = helper1(nums, i+1, true, false, false, cost + nums[i][0]);
		if(!skipGreen)
			case2 = helper1(nums, i+1, false, true, false, cost + nums[i][1]);
		if(!skipBlue)
			case3 = helper1(nums, i+1, false, false, true, cost + nums[i][2]);
		
		
		return Math.min(Math.min(case1, case2), case3);

	}
	
	private int helper2(int[][] nums){//linear Time Complexity and linear space complexity
		if( nums == null || nums.length == 0) {
			return 0;
		}
		int[][] costMatrix = new int[nums.length][3];
		costMatrix[0][0] = nums[0][0];
		costMatrix[0][1] = nums[0][1];
		costMatrix[0][2] = nums[0][2];
		
		for(int index =1; index < nums.length; index++){
			costMatrix[index][0] = nums[index][0] + Math.min(costMatrix[index-1][1], costMatrix[index-1][2]);
			costMatrix[index][1] = nums[index][1] + Math.min(costMatrix[index-1][0], costMatrix[index-1][2]);
			costMatrix[index][2] = nums[index][2] + Math.min(costMatrix[index-1][0], costMatrix[index-1][1]);
		}
		
		return Math.min(Math.min(costMatrix[nums.length-1][0], costMatrix[nums.length-1][1]), costMatrix[nums.length-1][2]);
	}
	
	private int helper3(int[][] nums){//linear time and constant space
		if( nums == null || nums.length == 0) {
			return 0;
		}
		int chosingRed = nums[0][0];
		int chosingGreen = nums[0][1];
		int chosingBlue = nums[0][2];
		
		for(int index =1; index < nums.length; index++){
			int tempR = chosingRed; int tempG = chosingGreen; int tempB = chosingBlue;
			chosingRed = nums[index][0] + Math.min(tempG, tempB);
			chosingGreen = nums[index][1] + Math.min(tempR, tempB);
			chosingBlue = nums[index][2] + Math.min(tempR, tempG);
		}
		
		return Math.min(Math.min(chosingRed, chosingGreen), chosingBlue);
	}

}



//Using DP Array
class PaintHouseColor {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int[][]dp = new int[costs.length][costs[0].length];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = costs[0][j];
                }else if(j == 0){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]);
                }else if(j == 1){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]);
                }else if(j == 2){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-2], dp[i-1][j-1]);
                }
            }
        }
        
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1],dp[dp.length-1][2]));
        
    }
}

//Using temp variables with constant space complexity
class PaintHouseColor {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        int chooseR = costs[0][0];int chooseB = costs[0][1]; int chooseG = costs[0][2];
        int tempR = 0, tempB = 0, tempG = 0;
        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                if(j == 0){
                    tempR = costs[i][j] + Math.min(chooseB, chooseG);
                }else if(j == 1){
                    tempB = costs[i][j] + Math.min(chooseR, chooseG);
                }else if(j == 2){
                    tempG = costs[i][j] + Math.min(chooseR, chooseB);
                }
            }
            chooseR = tempR;chooseG = tempG; chooseB = tempB;
        }
        
        return Math.min(chooseR, Math.min(chooseB,chooseG));
        
    }
}