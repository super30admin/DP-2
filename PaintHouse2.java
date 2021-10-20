public class PaintHouse2 {

    public int paintHouse2(int[][] costs) {
        // R G B
        // 0 1 2
        for (int i = 1; i < costs.length; i++) {
            // Red
            costs[0][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            // Green
            costs[0][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            // Blue
            costs[0][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}
