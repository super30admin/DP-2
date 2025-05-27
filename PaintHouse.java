

public class PaintHouse {

    public int minCost(int[][] costs) {
        int n = costs.length - 1;
        if (costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }

    public static void main(String[] args) {
        PaintHouse sol = new PaintHouse();

        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };

        int minPaintCost = sol.minCost(costs);
        System.out.println("Minimum cost to paint all houses: " + minPaintCost); // Output: 10
    }
}
