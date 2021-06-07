// Time Complexity : O(n)
// Space Complexity : O(1)

public class PaintHouse {
    public int getMinimumPrice(int[][] cost) {
        int price = 0;
        for (int i = 1; i < cost.length; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][1], cost[i - 1][0]);
        }
        price = Math.min(Math.min(cost[cost.length - 1][0], cost[cost.length - 1][1]), cost[cost.length - 1][2]);
        return price;
    }
}