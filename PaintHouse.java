//TC - 0(n)
//SC-O(1)

public class PaintHouse {
    public static void main(String[] args) {
        PaintHouse solution = new PaintHouse();
        int[][] costs = {
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}
        }; // Replace with your cost matrix

        int result = solution.minCost(costs);
        System.out.println("The minimum cost to paint all houses is: " + result);
    }

    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null)
            return 0;

        for(int i=costs.length - 2; i>=0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]);
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
