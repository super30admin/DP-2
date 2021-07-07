// The time Complexity is O(m) i.e only number of columns as row i.e colour is constant
// Space complexity is O(m) only

public class BigN21PaintHouseUsingNewMatrix {

	public int paintHouse(int[][] costs) {
		int row = costs.length;
		// edge case
		if (row == 0 || costs == null) {
			return 0;
		}
		int[][] dp = new int[row][3];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];

		for (int i = 1; i < row; i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		return Math.min(dp[row-1][2],(Math.min(dp[row-1][0],dp[row-1][1])));
	}
	
	public static void main(String Args[]) {
		BigN21PaintHouseUsingNewMatrix paint = new BigN21PaintHouseUsingNewMatrix();
		int [][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(paint.paintHouse(costs));
	}
}
