
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
