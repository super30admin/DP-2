// The time Complexity is O(m) i.e only number of columns as row i.e colour is constant
// Space complexity is O(1) as we not using any extra space

public class BigN21PaintHouseUsingInputMatrix {

	public int paintHouse(int[][] costs) {
		int row = costs.length;
		// edge case
		if (row == 0 || costs == null) {
			return 0;
		}
		for (int i = 1; i < row; i++) {
			costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		return Math.min(costs[row - 1][2], (Math.min(costs[row - 1][0], costs[row - 1][1])));
	}

	public static void main(String Args[]) {
		BigN21PaintHouseUsingInputMatrix paint = new BigN21PaintHouseUsingInputMatrix();
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		System.out.println(paint.paintHouse(costs));

	}
}
